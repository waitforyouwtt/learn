package com.book.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author${罗显}
 * @date 2018/12/3
 * @time 14:16
 * @model 大地还款计划 model
 */
public class ContinentRepaymentPlan implements Serializable {
    private static final long serialVersionUID = 2628115736014049080L;
    /**借款唯一标识loanId*/
    private String loanId;
    /**还款期次*/
    private Integer term;
    /**应还日期 yyyy-mm-dd*/
    private String shouldPayDate;
    /**应还本金*/
    private BigDecimal shouldPayAmount;
    /**应还利息*/
    private BigDecimal shouldPayInterest = BigDecimal.ZERO;
    /**应还罚息*/
    private BigDecimal shouldPayPenaltyInterest = BigDecimal.ZERO;
    /**应还复利*/
    private BigDecimal shouldPayCompoundInterest;
    /**实还日期 yyyy-mm-dd*/
    private String ActualPayDate;
    /**实还本金*/
    private BigDecimal realRepayPrincipal ;
    /**实还利息*/
    private BigDecimal realRepayProfit ;
    /**实还罚息*/
    private BigDecimal realFinedInterest = BigDecimal.ZERO;
    /**实还复利*/
    private BigDecimal realCompoundInterest = BigDecimal.ZERO;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getShouldPayDate() {
        return shouldPayDate;
    }

    public void setShouldPayDate(String shouldPayDate) {
        this.shouldPayDate = shouldPayDate;
    }

    public BigDecimal getShouldPayAmount() {
        return shouldPayAmount;
    }

    public void setShouldPayAmount(BigDecimal shouldPayAmount) {
        this.shouldPayAmount = shouldPayAmount;
    }

    public BigDecimal getShouldPayInterest() {
        return shouldPayInterest;
    }

    public void setShouldPayInterest(BigDecimal shouldPayInterest) {
        this.shouldPayInterest = shouldPayInterest;
    }

    public BigDecimal getShouldPayPenaltyInterest() {
        return shouldPayPenaltyInterest;
    }

    public void setShouldPayPenaltyInterest(BigDecimal shouldPayPenaltyInterest) {
        this.shouldPayPenaltyInterest = shouldPayPenaltyInterest;
    }

    public BigDecimal getShouldPayCompoundInterest() {
        return shouldPayCompoundInterest;
    }

    public void setShouldPayCompoundInterest(BigDecimal shouldPayCompoundInterest) {
        this.shouldPayCompoundInterest = shouldPayCompoundInterest;
    }

    public String getActualPayDate() {
        return ActualPayDate;
    }

    public void setActualPayDate(String actualPayDate) {
        ActualPayDate = actualPayDate;
    }

    public BigDecimal getRealRepayPrincipal() {
        return realRepayPrincipal;
    }

    public void setRealRepayPrincipal(BigDecimal realRepayPrincipal) {
        this.realRepayPrincipal = realRepayPrincipal;
    }

    public BigDecimal getRealRepayProfit() {
        return realRepayProfit;
    }

    public void setRealRepayProfit(BigDecimal realRepayProfit) {
        this.realRepayProfit = realRepayProfit;
    }

    public BigDecimal getRealFinedInterest() {
        return realFinedInterest;
    }

    public void setRealFinedInterest(BigDecimal realFinedInterest) {
        this.realFinedInterest = realFinedInterest;
    }

    public BigDecimal getRealCompoundInterest() {
        return realCompoundInterest;
    }

    public void setRealCompoundInterest(BigDecimal realCompoundInterest) {
        this.realCompoundInterest = realCompoundInterest;
    }

    @Override
    public String toString() {
        return "ContinentRepaymentPlan{" +
            "loanId='" + loanId + '\'' +
            ", term=" + term +
            ", shouldPayDate='" + shouldPayDate + '\'' +
            ", shouldPayAmount=" + shouldPayAmount +
            ", shouldPayInterest=" + shouldPayInterest +
            ", shouldPayPenaltyInterest=" + shouldPayPenaltyInterest +
            ", shouldPayCompoundInterest=" + shouldPayCompoundInterest +
            ", ActualPayDate='" + ActualPayDate + '\'' +
            ", realRepayPrincipal=" + realRepayPrincipal +
            ", realRepayProfit=" + realRepayProfit +
            ", realFinedInterest=" + realFinedInterest +
            ", realCompoundInterest=" + realCompoundInterest +
            '}';
    }
}
