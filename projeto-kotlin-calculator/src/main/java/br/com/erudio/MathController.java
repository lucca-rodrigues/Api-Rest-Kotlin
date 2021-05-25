package br.com.erudio;
import br.com.erudio.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

  @RestController
  public class MathController {

   @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
    return sum;
   }

   @RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
    return sum;
   }

   @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
    return sum;
   }

   @RequestMapping(value="/division/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
    return sum;
   }

   @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo)/2;
    return sum;
   }

   @RequestMapping(value="/squareRoot/{numberOne}/{numberTwo}", method= RequestMethod.GET)
   public Double squareRoot(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
    if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
     throw new UnsuportedMathOperationException("Please set a numeric value");
    }
    Double sum = (Double) Math.sqrt(convertToDouble(number));
    return sum;
   }

   private Double convertToDouble(String stringNumber){
    if(stringNumber == null) return  0D;
    String number = stringNumber.replace(",",".");
    if(isNumeric(number)) return Double.parseDouble(number);
    return 0D;
   }

   private boolean isNumeric(String stringNumber){
    if(stringNumber == null) return false;
    String number = stringNumber.replaceAll(",",".");
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
   }
}
