public class iPhoneFactory implements Factory {
 
 @Override
 public Sarj_Cihazi makeSarjCihazi() {
  return new iPhone_Sarj_Cihazi();
 }
 
 @Override
 public Usb_Kablo makeUsbKablo() {
  return new iPhone_Usb_Kablo();
 }
}
