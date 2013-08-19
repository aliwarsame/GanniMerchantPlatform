package com.gannimerchant.offers;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class SystemUnavailableException extends Exception {

}
