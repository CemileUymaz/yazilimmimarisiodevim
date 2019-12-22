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
package Abstract_Factory_Design_Pattern;

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
Sarj_Cihazi abstract sınıfı yukarıdaki kod ile kodlanıyor. Yapıcı metodunda şarj cihazı modeli bilgisinin alınması bilgi sahibi  olmayı sağlar. <br/>

```java
package Abstract_Factory_Design_Pattern;

public class Lg_Sarj_Cihazi extends Sarj_Cihazi {

   public Lg_Sarj_Cihazi() {
      super("LG şarj Cihazı");
   }
}
```
```java
package Abstract_Factory_Design_Pattern;

public class iPhone_Sarj_Cihazi extends Sarj_Cihazi {
    
    public iPhone_Sarj_Cihazi() {
       super("iPhone şarj Cihazi");
    }
}
```
Sarj_Cihazi sınıfı iphone ve lg için üretilen sınıflara miras yolu ile tanımlanmaktadır. <br/>

```java
package Abstract_Factory_Design_Pattern;

public abstract class Usb_Kablo {

    private String kabloModel;
    
    public Usb_Kablo(String kabloModel) {
        this.kabloModel=kabloModel;
    }
    
    public String getKabloModel() {
       return kabloModel;
    }
 }
```
Usb_Kablo sınıfı yukarıdaki şekilde ile kodlanıyor. Constructor(yapıcı) metot üzerinden kablo modeli bilgisinin alınması bilgi sahibi olmayı sağlar.

```java
package Abstract_Factory_Design_Pattern;

public class Lg_Usb_Kablo extends Usb_Kablo {

    public Lg_Usb_Kablo() {
       super("LG Usb Kablo");
    }
}
```
```java
package Abstract_Factory_Design_Pattern;

public class iPhone_Usb_Kablo extends Usb_Kablo{

     public iPhone_Usb_Kablo() {
         super("iPhone USB Kablo");
     }
}
```
Yukarıdaki kodlarda Usb_Kablo sınıfının alt sınıfları oluşturularak her marka için ayrı bir usb kablo sınıfı oluşturulmaktadır.

```java
package Abstract_Factory_Design_Pattern;

public interface Factory {
   public Sarj_Cihazi makeSarjCihazi();
   public Usb_Kablo makeUsbKablo();
}
```
Factory interface sınıfı ile bir fabrikada yapılması istenen işlemler için olması istenen metotlar tanımlanmaktadır.

```java
package Abstract_Factory_Design_Pattern;

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
```
```java
package Abstract_Factory_Design_Pattern;

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
```
Yukarıdaki kodlar ile iPhone ve LG Factory interface alt sınıfları oluşturulmaktadır.Bu sınıflar aracılığıyla her markanın sadece kendisine ait parçaların üretilmesi sağlanıyor.

```java
package Abstract_Factory_Design_Pattern;

public class FactoryMaker {
   public static Factory getFactory(String factoryName){
      if(factoryName.equals("lg"))
          return new LgFactory();
      else if(factoryName.equals("iphone"))
          return new iPhoneFactory();
          
      return null;
   }
}
```
FactoryMaker sınıfında ise talep edilen marka parametre olarak alınarak bu markaya ait Factory alt interface sınıfı döndürülmektedir.  

```java
package Abstract_Factory_Design_Pattern;

public class Client {
   public void doSomeClientJob(String factoryName){
      Usb_Kablo usbKablo=FactoryMaker.getFactory(factoryName).makeUsbKablo();
      System.out.println(usbKablo.getKabloModel());
      
      Sarj_Cihazi sarjCihazi=FactoryMaker.getFactory(factoryName).makeSarjCihazi();
      
      System.out.Println(sarjCihazi.getSarjCihaziModel());
   }
}
```
Client sınıfı ile istenilen markaya özel kablo ve şarj cihazı FactoryMaker sınıfı kullanılarak üretimi sağlanıyor ve ekran çıktıları alınmaktadır.

```java
package Abstract_Factory_Design_Pattern;

public class Test {
   public static void main(String[] args) {
      Client client = new Client();
      client.doSomeClientJob("lg");
   }
}
```
Test sınıfında ise sadece lg markasını yazarak kullanıcı arkada hangi sınıf ve alt sınıfların çalışacağını bilmeden aşağıdaki çıktıyı elde etmektedir. <br/>
**LG Usb Kablo** <br/>
**Lg Şarj Cihazı**

<br/> <br/> <br/> <br/>
## Adaptör (Adapter) Tasarım Deseni
Adaptör tasarım deseni, structural tasarım desenlerinden biridir. Bu tasarım deseni, birbiriyle ilişkili olmayan interface'lerin birlikte çalışmasını sağlar. Bu işlemi ise, bir sınıfın interface'ini diğer bir interface'e dönüştürerek yapar.  
İsmini gerçek hayattaki adaptörlerden alan adapter tasarım deseni farklı interface'lere sahip sınıfların birbiriyle çalışabilmesini sağlamak amacıyla kullanılır. Ayrıca adaptasyon işlemi sırasında, adapte edilen nesnenin desteklemediği özellikler de adaptör tarafından gerçekleştirilebilir. <br/> <br/>
Kullanımı: Var olan sistemin interface'i, target interface olarak adlandırılır. Bu interface'i implement edecek bir Adapter sınıfı yaratılır.  Adapter sınıfında, Adaptee interface türünden bir sınıf değişkeni bulunur. Son olarak client sınıfı Adapter sınıfı nesnesi ve Adaptee nesnesini yaratır.  <br/> <br/>
Faydaları:
1. Birbiriyle ilişkili olmayan interface'lerin birlikte çalışmasını sağlar.
2. Kodların yeniden yazılması engeller.
3. Var olan modül(ler) değiştirilmeden sisteme yeni modüller eklenebilir.  <br/> <br/>

Adapter Tasarım Deseni Örneği:
240V ve 120V elektrik veren prizlerden cep telefonlarını  şarj etmek için kullanılan telefon şarj ediciler aslında 120/240 V → 3V dönüştürü adaptörlerdir.
Örnek kodda 120V üreten bir Socket bulunmaktadır. <br/> <br/>

resim
 <br/>
 Classların kodlanması:
 
 ```java
 public class Volt {
 
    private int volts;
    
    public Volt(int v) {
        this.volts=v;
    }
    
    public int getVolts() {
       return volts;
    }
    
    public void setVolts(int volts) {
       this.volts = volts;
    }
 }
 ```
 Volt sınıfı yukarıdaki şekilde kodlanmaktadır. Yapıcı metot üzerinden volt bilgisi alınmaktadır. <br/>
 
 ```java
 public class Socket {
    
    public Volt getVolt(){
        return new Volt(120);
    }
}
```
Socket sınıfı da yukarıdaki şekilde kodlanmaktadır. SocketAdapter çıktıyı 120, 12 ve 3 volt olacak şekilde vermektedir. <br/> <br/>
2 tip Adapter



