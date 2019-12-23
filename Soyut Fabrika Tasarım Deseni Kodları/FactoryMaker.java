public class FactoryMaker {
 public static Factory getFactory(String factoryName){
  if(factoryName.equals("lg"))
   return new LgFactory();
  else if(factoryName.equals("iphone"))
   return new iPhoneFactory();
  
  return null;
 }
 
}