public class Client {
 public void doSomeClientJob(String factoryName){
  Usb_Kablo usbKablo=FactoryMaker.getFactory(factoryName).makeUsbKablo();
  System.out.println(usbKablo.getKabloModel());
  
  Sarj_Cihazi sarjCihazi=FactoryMaker.getFactory(factoryName).makeSarjCihazi();
  System.out.println(sarjCihazi.getSarjCihaziModel());
 }
}