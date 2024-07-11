import org.scalatest.wordspec.AnyWordSpec

class TaxCalculatorSpec extends AnyWordSpec {

  val taxCalculator: TaxCalculator = new TaxCalculator

  // I've done the first test for you!
  "TaxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }
      "the income is within the basic rate limit" in {
        val result: Double = taxCalculator.calculateTax(20000)

        assert(result == 2000)
      }
      "the income is within the higher rate limit"
    }
  }

  //Second Test
  "TaxCalculator.isHigherRateTaxpayer" should {
    "return whether the payee is a higher rate tax payer" when {
      "the income is above the higher rate tax limit" in {
        val result: Double = taxCalculator.isHigherRateTaxpayer(125000)

        assert(result > 0)
      }
    }
  }

  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxpayer(income: Double): Boolean = {
    ???
  }


  //Third Test
  "TaxCalculator.calculateTax" should {
    "return a string with the income limit of the payee's current tax band" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }
    }
  }
}

// A method that will return a string with the income limit of their current tax band.
// The return will also be formatted, E.g: "£12,500" or "No limit"
def formattedCurrentTaxAllowance(income: Double): String = {
  ???
}



//class TaxCalculator {
//
//  // Tax bands (simplified to make testing a bit easier)
//  private val personalAllowance: Int = 10000
//  private val basicRateLimit: Int = 50000
//  private val higherRateLimit: Int = 125000
//
//  // Tax rates
//  private val personalAllowanceRate: Double = 0
//  private val basicRate: Double = 0.2
//  private val higherRate: Double = 0.4
//  private val additionalRate: Double = 0.45

