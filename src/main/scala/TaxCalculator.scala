class TaxCalculator {

  // Tax bands (simplified to make testing a bit easier)
  private val personalAllowance: Int = 10000
  private val basicRateLimit: Int = 50000
  private val higherRateLimit: Int = 125000

  // Tax rates
  private val personalAllowanceRate: Double = 0
  private val basicRate: Double = 0.2
  private val higherRate: Double = 0.4
  private val additionalRate: Double = 0.45

  // A method to calculate the total amount of tax to be paid, returned as a double
  def calculateTax(income: Double): Double = {
    if (income > 0 && income <= personalAllowance) {
      0
    } else if (income <= basicRateLimit) {
      (income - personalAllowance) * basicRate
    } else if (income <= higherRateLimit) {
      (basicRateLimit - personalAllowance) * basicRate + (income - basicRateLimit) * higherRate
    } else if (income > higherRateLimit) {
        (basicRateLimit * basicRate) + (higherRateLimit - basicRateLimit) * higherRate + (income - higherRateLimit) * additionalRate
    }else {
      404 //Would be better to add an error message here, but not learned doubles yet
    }
  }

  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxpayer(income: Double): Boolean = {
    income > basicRateLimit
  }


  // A method that will return a string with the income limit of their current tax band.
  // The return will also be formatted, E.g: "£12,500" or "No limit"
  def formattedCurrentTaxAllowance(income: Double): String = {
    if (income < 0) {
      "Invalid Input"
    } else if (income <= personalAllowance) {
      f"£$personalAllowance%,d"
    } else if (income > personalAllowance && income <= basicRateLimit) {
      f"£$basicRateLimit%,d"
    } else if (income > basicRateLimit && income <= higherRateLimit) {
      f"£$higherRateLimit%,d"
    } else {
      f"No Limit"
    }
  }

  // Capital Gains Tax bands (simplified to make testing a bit easier)
  private val gainsAllowance: Int = 3000
  private val basicGainsLimit: Int = 50000

  // Tax rates
  private val basicGainsRate: Double = 0.1
  private val basicGainsResidentialRate: Double = 0.18
//  private val basicGainsCryptoRate: Double = 0.1
//  private val basicGainsOtherRate: Double = 0.1
  private val higherGainsRate: Double = 0.2
  private val higherGainsResidentialRate: Double = 0.24
//  private val higherGainsCryptoRate: Double = 0.2
//  private val higherGainsOtherRate: Double = 0.2

  //Could put in info to consider loss, disposal relief, wasting assets etc

  def calculateCapitalGainsTax(gains: Double): Double = {
    if (gains > 0 && gains <= gainsAllowance) {
      0
    } else if (gains <= basicGainsLimit) {
      (gains - gainsAllowance) * basicGainsRate
    } else if (gains > basicGainsLimit) {
      (gains - gainsAllowance) * higherGainsRate
    }else {
      404 //Would be better to add an error message here, but not learned doubles yet
    }
  }

}
