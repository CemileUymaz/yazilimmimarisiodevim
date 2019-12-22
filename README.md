# yazilimmimarisiodevim

## Soyut Fabrika ( Abstract Factory )
Soyut fabrika tasarım deseni, cretional (yaratımsal) tasarım desenlerinden birisidir. Bu desene fabrikaların fabrikası(factories of the factory) da denir.
Bu tasarım deseni, birbiriyle alakalı veya bağımlı nesnelerin somut sınıflarını belirtmeden,yaratılması için gerekli olan arayüzü sağlar. Birbirlerinden farklı yapılarda fakat ortak işlevlere sahip birçok nesne üretme ihtiyacı duyulabilir. Bu nesneler de; kendi içlerinde bağlı oldukları diğer nesneleri üretmek zorundadır. Bu durumda soyut fabrika tasarım deseni kullanılır. Fabrika tasarım deseni ile farkı: fabrika tasarım deseni tek tip nesne oluşturulur, soyut fabrika deseni ise birden fazla fabrika deseni ile hiyerarşik yapıda oluşturularak çeşitli tipte nesneler oluşturur. <br/> <br/>
Kullanımı: Her bir Product alt sınıfları için bir fabrika sınıfı oluşturmak gereklidir. Bu oluşturulacak fabrika sınıfları ise türü interface veya abstract olan bir süper fabrika sınıfından türemelidir. <br/> <br/>
Faydaları:
1. Client (istemci) sınıfına, bir abstract arayüz kullanmasını sağlayarak, gerçekte üretilecek ilişkili Product sınıflarını bilmeden veya önemsemeden oluşturulmasına olanak tanır.
2. if-else yapısından kurtararak daha anlaşılır kod yazmayı sağlar. <br/> <br/>

Soyut Fabrika Tasarım Deseni Örneği:
iPhone ve LG telefonlar için parça üreten bir fabrikada, iPhone ve LG için ayrı şarj kablosu ve şarj cihazı üreten fabrikanın kullandığı soyut fabrika deseni: <br/> <br/>

![soyut tasarım deseni class dig1](https://user-images.githubusercontent.com/59052653/71321724-ddb96880-24ce-11ea-8b00-179c7227dba9.png)
<br/>
Factory interface sınıfı LgFactory ve İPhoneFactory alt interface sınıflarını oluşturmaktadır.
Sarj_Cihazi abstract sınıfın ise LG_Sarj_Cihazi ve iPhone_Sarj_Cihazi adında alt sınıfları oluşturarak farklı şarj cihazları üretilmesi sağlıyor. Usb_Kablo sınıfıda Lg_Usb_Kablo ve iPhone_Usb_Kablo alt sınıflarını oluşturarak farklı usb kabloların oluşturulmasını sağlıyor. Factory interface sınıfının alt sınıfları, LG ve iPhone markalarına özel usb kablosu ve  şarj cihazlarını kullanıcının bilgisi olmadan üretilmesini sağlayacaktır. <br/> <br/>

```java
public abstract class Sarj_Cihazi {
   private String sarjCihaziModel;
   
   public Sarj_Cihazi(String sarjCihaziModel){
       this.sarjCihaziModel=sarjCihaziModel;
   }
   
   public String getSarjCihaziModel() {
       return sarjCihaziModel;
   }
}
```
Sarj_Cihazi abstract sınıfı yukarıdaki kod ile kodlanıyor. Yapıcı metodunda şarj cihazı modeli bilgisinin alınması bilgi sahibi  olmayı sağlar. 



