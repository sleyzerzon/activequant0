/*******************************************************************************
 * Copyright (c) quickfixengine.org  All rights reserved. 
 * 
 * This file is part of the QuickFIX FIX Engine 
 * 
 * This file may be distributed under the terms of the quickfixengine.org 
 * license as defined by quickfixengine.org and appearing in the file 
 * LICENSE included in the packaging of this file. 
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING 
 * THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE. 
 * 
 * See http://www.quickfixengine.org/LICENSE for licensing information. 
 * 
 * Contact ask@quickfixengine.org if any conditions of this licensing 
 * are not clear to you.
 ******************************************************************************/

package org.activequant.tradesystem.domainmodel2;

import org.activequant.core.domainmodel.InstrumentSpecification;
import org.activequant.core.types.TimeStamp;

/**
 * Order to sell/buy contracts.
 * <br>
 * <b>History:</b><br>
 *  - [11.12.2007] Created (Mike Kroutikov)<br>
 *
 *  @author Mike Kroutikov
 */
public class Order {

	/**
	 * Enumerates order types.
	 */
	public enum Type {
		MARKET, 
	    LIMIT, 
	    STOP, 
	    STOP_LIMIT, 
	    TRAILING_STOP;
	}
	
	/**
	 * Enumerates order side values.
	 */
	public enum Side {
		BUY, 
	    SELL, 
	    SHORT_SELL, 
	    SHORT_SELL_EXEMPT,
	    CROSS,
	    CROSS_SHORT,
	    CROSS_SHORT_EXEPMT;
	}
	
	/**
	 * Enumerates time-in-force values.
	 */
	public enum TimeInForce {
		DAY, 
	    IMMEDIATE_OR_CANCEL, 
	    OPG, 
	    GOOD_TILL_CANCELED,
	    GOOD_TILL_EXPIRES;
	}
	
	private Long id;
	private Type orderType = Type.MARKET;
    private InstrumentSpecification instrumentSpecification;
    private Side side = Side.BUY;
    private TimeStamp orderTimeStamp;
    private TimeStamp executionTargetTimeStamp;
    private TimeStamp expirationTimeStamp;
    private TimeInForce timeInForce = TimeInForce.DAY;
    private double quantity;
	private double limitPrice;
	private double stopPrice;
	private double trailingDistance;
	
	/**
	 * Creates empty order.
	 */
	public Order() { }
	
	/**
	 * Duplicates an order.
	 * 
	 * @param other model order.
	 */
	public Order(Order other) {
		this.id = other.id;
		this.orderType = other.orderType;
		this.instrumentSpecification = other.instrumentSpecification;
		this.side = other.side;
		this.orderTimeStamp = other.orderTimeStamp;
		this.executionTargetTimeStamp = other.executionTargetTimeStamp;
		this.expirationTimeStamp = other.expirationTimeStamp;
		this.timeInForce = other.timeInForce;
		this.quantity = other.quantity;
		this.limitPrice = other.limitPrice;
		this.stopPrice = other.stopPrice;
		this.trailingDistance = other.trailingDistance;
	}
	
	public boolean hasId() {
		return id != null;         
	}          
	
	/**
	 * Persistence identity (usually auto-generated by the database).
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the persistence identity.
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Order type (MARKET/LIMIT/STOP_LIMIT, etc).
	 * 
	 * @return type.
	 */
	public Type getOrderType() {
		return orderType;
	}
	
	/**
	 * Sets order type.
	 * 
	 * @param type order type.
	 */
	public void setOrderType(Type type) {
		orderType = type;
	}
    
	/**
	 * Instrument to buy/sell.
	 * 
	 * @return instrument specification;
	 */
    public InstrumentSpecification getInstrumentSpecification() {
        return instrumentSpecification;
    }
    
    /**
     * Sets which instrument to buy/sell.
     * 
     * @param instrumentSpecification instrument specification.
     */
    public void setInstrumentSpecification(InstrumentSpecification instrumentSpecification) {
        this.instrumentSpecification = instrumentSpecification;
    }

    /**
     * Order side.
     * 
     * @return order side.
     */
	public Side getOrderSide() {
		return side;
	}

	/**
	 * Sets order side.
	 * 
	 * @param side order side.
	 */
	public void setOrderSide(Side side) {
		this.side = side;
	}

	/**
	 * Time-in-force for this order.
	 * 
	 * @return
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * Sets time-in-force for this order.
	 * 
	 * @param tif time in force.
	 */
	public void setTimeInForce(TimeInForce tif) {
		this.timeInForce = tif;
	}

	/**
	 * Time stamp when the order has been created.
	 * 
	 * @return order time stamp.
	 */
	public TimeStamp getOrderTimeStamp() {
		return orderTimeStamp;
	}

	/**
	 * Sets order creation time stamp.
	 * 
	 * @param orderDate order time stamp.
	 */
	public void setOrderTimeStamp(TimeStamp orderStamp) {
		this.orderTimeStamp = orderStamp;
	}

    /**
     * Specifies when an order must be executed.
     * This could be relevant when using the paper broker implementation.
     * It also reflects a "good starting at".   
     * <p/>
     * An executionPoint of null expresses that the order is executed as soon as possible (does 
     * not collide with Time In Force, as TIF is used at the broker's/exchange's end).  
     */
	public TimeStamp getExecutionTargetTimeStamp() {
		return executionTargetTimeStamp;
	}

	/**
	 * Sets execution target time stamp.
	 * 
	 * @param val execution target time stamp.
	 */
	public void setExecutionTargetTimeStamp(TimeStamp val) {
		this.executionTargetTimeStamp = val;
	}
	
	/**
	 * Order expiration time stamp for the orders with the appropriate
	 * <code>timeInForce</code> value.
	 * 
	 * @return expiration time stamp.
	 */
	public TimeStamp getExpirationTimeStamp() {
		return this.expirationTimeStamp;
	}
	
	/**
	 * Sets the expiration time stamp.
	 * 
	 * @param val expiration time stamp.
	 */
	public void setExpirationTimeStamp(TimeStamp val) {
		this.expirationTimeStamp = val;
	}

    /**
     * Quantity of instrument to buy/sell.
     * 
     * @return quantity.
     */
    public double getQuantity() {
        return quantity;
    }
    
    /**
     * Sets the quantity.
     * 
     * @param quantity quantity.
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

	/**
	 * Limit price.
	 * 
	 * @return limit price.
	 */
	public double getLimitPrice() {
		return limitPrice;
	}
	
	/**
	 * Sets limit price.
	 * 
	 * @param val limit price.
	 */
	public void setLimitPrice(double val) {
		limitPrice = val;
	}


	/**
	 * Stop price.
	 * 
	 * @return stop price.
	 */
	public double getStopPrice() {
		return stopPrice;
	}
	
	/**
	 * Sets stop price.
	 * 
	 * @param val stop price.
	 */
	public void setStopPrice(double val) {
		stopPrice = val;
	}

	/**
	 * Trailing distance.
	 * 
	 * @return trailing distance.
	 */
	public double getTrailingDistance() {
		return trailingDistance;
	}
	
	/**
	 * Sets trailing distance.
	 * 
	 * @param val trailing distance.
	 */
	public void setTrailingDistance(double val) {
		trailingDistance = val;
	}
	
    public String toString() {
    	return "Order: type=" + getOrderType()
    		+ ", instrument=" + getInstrumentSpecification()
    		+ ", side=" + getOrderSide()
    		+ ", quantity=" + getQuantity()
    		+ ", orderTimeStamp=" + getOrderTimeStamp()
    		+ ", executionTragetTimeStamp=" + getExecutionTargetTimeStamp()
    		+ ", expirationTimeStamp=" + getExpirationTimeStamp()
    		+ ", timeInForce=" + getTimeInForce()
    		+ ", orderTimeStamp=" + getOrderTimeStamp()
    		+ ", stopPrice=" + getStopPrice()
    		+ ", limitPrice=" + getLimitPrice()
    		+ ", trailingDistance=" + getTrailingDistance();
    }
}