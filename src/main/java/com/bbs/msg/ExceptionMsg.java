package com.bbs.msg;

import java.io.Serializable;

public class ExceptionMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Exception err;

	public Exception getErr() {
		return err;
	}

	public void setErr(Exception err) {
		this.err = err;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ExceptionMsg(Exception err) {
		super();
		this.err = err;
	}

	

}
