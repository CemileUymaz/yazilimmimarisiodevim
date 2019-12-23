public class LgFactory implements Factory {
 @Override
 public Sarj_Cihazi makeSarjCihazi() {
  return new Lg_Sarj_Cihazi();
 }
 
 @Override
 public Usb_Kablo makeUsbKablo() {
  return new Lg_Usb_Kablo();
 }
 
}