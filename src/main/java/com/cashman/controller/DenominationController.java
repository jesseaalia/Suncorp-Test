package com.cashman.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cashman.enumeration.Currencydto;
import com.cashman.exception.helper.ErrorInfo;
import com.cashman.model.ATMResponse;
import com.cashman.model.Denomination;
import com.cashman.service.DenominationService;
import com.cashman.util.Constants;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/denominations")
public class DenominationController {

	@Autowired
	private DenominationService denominationService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createDenominationPage() {
		Denomination denomination = denominationService.get(1);
		
		ModelAndView mav = new ModelAndView("currency/enterdenom");
		mav.addObject(Constants.Denom, denomination);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Denomination saveDenomination(
			@RequestBody @Validated Denomination denomination) {
		return denominationService.create(denomination);
	}

	@RequestMapping(value = "/withdraw/{withdrawcash}", method = RequestMethod.GET)
	public ModelAndView editDenominationPage1(@PathVariable int withdrawcash) {
		ModelAndView mav = new ModelAndView("currency/edit-denoms");
		Denomination denomination = denominationService.get(1);
		denomination.getAvailablecash();
		denomination.setWithdrawcash(new BigDecimal(withdrawcash));
		mav.addObject(Constants.Denom, denomination);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDenominationPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("currency/edit-denoms");
		Denomination  denomination = denominationService.get(id);
		mav.addObject("denom", denomination);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView   editDenomination(@PathVariable int id,
			@Validated @RequestBody Denomination denom) {
		denom.setId(id);
		String res = denominationService.update(denom);
		Denomination denomination = denominationService.get(id);
		denomination.setStatus(res);
		ModelAndView mav = new ModelAndView("currency/edit-denoms");
		mav.addObject("denom", denomination);
		return mav;
		
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Denomination deleteDenomination(@PathVariable int id) {
		return denominationService.delete(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Denomination  allDenominations() {
		return denominationService.get(1);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView allDenominationPage() {
		ModelAndView mav = new ModelAndView("currency/all-denoms");
//		List<Denomination> denominations = new ArrayList<Denomination>();
//		denominations.addAll(allDenominations());
		mav.addObject(Constants.Denom, denominationService.get(1));
		return mav;
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleTypeMismatchException(HttpServletRequest req,
			TypeMismatchException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage(
				"error.bad.smartphone.id", null, locale);

		errorMessage += ex.getValue();
		String errorURL = req.getRequestURL().toString();

		return new ErrorInfo(errorURL, errorMessage);
	}

}
