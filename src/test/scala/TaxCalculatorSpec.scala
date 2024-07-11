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
      "the income is within the higher rate limit" in {
        val result: Double = taxCalculator.calculateTax(60000)

        assert(result == 12000)
      }
      "the income is above the higher rate limit" in {
        val result: Double = taxCalculator.calculateTax(150000)

        assert(result == 51250)
      }
    }
  }

  //Second Test
  "TaxCalculator.isHigherRateTaxpayer" should {
    "return whether the payee is a higher rate tax payer" when {
      "the income is below the higher rate tax limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(25000)

        assert(!result)
      }
      "the income is above the higher rate tax limit" in {
        val result: Boolean = taxCalculator.isHigherRateTaxpayer(95000)

        assert(result)
      }
    }
  }

  //Third Test
  "TaxCalculator.calculateTax" should {
    "return a string with the income limit of the payee's current tax band" when {
      "the income is below 0" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(-4)

        assert(result == "Invalid Input")
      }
      "the income is below the personal tax limit" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(5000)

        assert(result == "£10,000")
      }
      "the income is within the basic rate limit" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(20000)

        assert(result == "£50,000")
      }
      "the income is within the higher rate limit" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(60000)

        assert(result == "£125,000")
      }
      "the income is above the higher rate limit" in {
        val result: String = taxCalculator.formattedCurrentTaxAllowance(150000)

        assert(result == "No Limit")
      }
    }
  }
}
