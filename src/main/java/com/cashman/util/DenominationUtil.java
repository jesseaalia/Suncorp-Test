package com.cashman.util;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.cashman.interfaces.Money.Money;

@Component
public class DenominationUtil {

	DenominationUtil() {
	}

	/*Caluclates denominations and verify funds available*/
	public static Map<Money, Integer> calculateWithdraw(BigDecimal withdrawAmt,
			Map<Money, Integer> count) {
		Map<Money, Integer> toWithdraw = new HashMap<Money, Integer>();
		List<Money> denominations = count.entrySet().stream()
				.filter(entry -> entry.getValue() > 0).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		// reverse sort denominations
		denominations.sort(Comparator.comparing(Money::getValue).reversed());

		for (int i = 0; i < denominations.size(); i++) {
			toWithdraw = calculateDenominations(i, denominations, withdrawAmt,
					count);
			if (fundsAvailable(toWithdraw, count)) {
				break;
			}
		}

		return toWithdraw;
	}

	/* Verify funds available or not for given amount */
	public static boolean fundsAvailable(Map<Money, Integer> toWithdraw,
			Map<Money, Integer> count) {
		if (count.size() > 0) {
			for (Map.Entry<Money, Integer> entry : toWithdraw.entrySet()) {
				if (!count.containsKey(entry.getKey()))
					return false;
				if (count.get(entry.getKey()) < entry.getValue())
					return false;
			}
			return true;
		} else {
			return false;
		}

	}

	/* Caluclates Denominations to withdraw  */
	public static Map<Money, Integer> calculateDenominations(int position,
			List<Money> denominations, BigDecimal amount,
			Map<Money, Integer> countmap) {
		Map<Money, Integer> toWithdraw = new HashMap<>();
		for (int variation = 0; variation < getTotalCount(countmap); variation++) {
			toWithdraw.clear();
			double amountTmp = amount.doubleValue();// withdrawlamt
			int variationTmp = variation;
			for (int i = position; i < denominations.size(); i++) {
				double value = denominations.get(i).getValue().doubleValue();// 20
				if (value <= amountTmp) {// 20<=50
					double count = (amountTmp / value) - variationTmp;// 2.5
					int c = (int) Math.floor(count);// 2
					toWithdraw.put(denominations.get(i), c);
					amountTmp = BigDecimal
							.valueOf(amountTmp)
							.subtract(
									BigDecimal.valueOf(c).multiply(
											BigDecimal.valueOf(value)))
							.doubleValue();
					variationTmp = 0;
					if (getTotal(toWithdraw).compareTo(amount) == 0) {
						return toWithdraw;
					}
				}
			}
		}
		return toWithdraw;
	}

	/* Caluclates total amount toWithdraw */
	public static BigDecimal getTotal(Map<Money, Integer> count) {
		BigDecimal sum = BigDecimal.ZERO;
		for (Map.Entry<Money, Integer> entry : count.entrySet()) {
			sum = sum.add(entry.getKey().getValue()
					.multiply(new BigDecimal(entry.getValue().intValue())));
		}
		return sum;
	}

	public static int getCount(Money denomination, Map<Money, Integer> count) {
		return count.containsKey(denomination) ? count.get(denomination) : 0;
	}

	/* returns total denomination count */
	public static int getTotalCount(Map<Money, Integer> count) {
		int sum = 0;
		for (Map.Entry<Money, Integer> entry : count.entrySet()) {
			sum += getCount(entry.getKey(), count);
		}

		return sum;// 5
	}
}
