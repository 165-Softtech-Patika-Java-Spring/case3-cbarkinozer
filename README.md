# Case3

Bir online alışveriş sitesinin kullanıcı yorumlarını yöneten bir api yazınız.
- Bir kullanıcının sadece bir e-maili ve bir telefon numarası olabilir. ✓
- Aynı kullanıcı adı, telefon ya da e-mail ile kayıt yapılamaz.
- Kullanıcı tipi kişi ya da kurum olabilir. ✓
1. **Ürün controller ında**;
-  Ürün kaydeden bir servis yazınız.(save) ✓
 - Ürünleri listeleyebilen bir servis yazınız.(findAll) ✓
  - Ürün idsinden ürünü bulan bir servis yazınız.(findById) ✓
  - Ürün silen bir metot yazınız.(delete) ✓
  - Ürün fiyatı güncelleyen bir metot yazınız. (Sadece fiyat) (updatePrice) ✓
  
2. **Kullanıcı controller ında;**  
- Tüm kullanıcıları getiren bir servis yazınız. (findAll) 
- Kullanıcı idsinden kullanıcıyı getiren bir servis yazınız. (findById)  
- Kullanıcı adından kullanıcıyı getiren bir servis yazınız.  (findBy)
- Kullanıcı kaydedilebilecek bir servis yazınız.  (findByUsername)
- Kullanıcı silebilecek bir servis yazınız. (kullanıcı adı, ve telefon bilgileri alınmalı).(deleteWithControl)  
- Eğer kullanıcı adı ve telefon uyuşmuyorsa “XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.”
şeklinde bir uyarı vermeli.  
- Kullanıcı bilgilerini güncelleyebilecek bir servis yazınız.  (update)

3. **Yorum Controller ında;**
- Bir kullanıcının yaptığı yorumlari getiren bir servis yazınız. Eğer ilgili kullanıcının henüz bir
yorumu yoksa “XXX kullanıcı henüz bir yorum yazmamıştır” şeklinde bir hata vermeli. (findByUserIdWithControl)  
- Bir ürüne yapılan tüm yorumları getiren bir servis yazınız. Eğer o ürüne henüz bir yorum  (findAllByProductIdWithControl)
yazılmamışsa “XXX ürüne henüz bir yorum yazılmamıştır” şeklinde bir hata vermeli.  
- Yeni bir yorum yazılabilecek bir servis yazınız. (save)  
- Yorum silebilecek bir servis yazınız.  (delete)

#### Notlar:
Yukarıdaki hiçbir servis Persistance nesne almamalı ya da dönmemelidir.(dto ve mapper kullan) ✓  
Pathlere dikkat ediniz.  
Dao ve entityService deki method isimlerine dikkat ediniz.  
Dto isimlendirmeleri, fieldları vs size bırakıyorum.  ✓
Spring Data JPA da sorgu yazmak ile alakalı ya da otomatik sorguların nasıl yapıldığı ile alakalı da ufak
bir araştırma yapmanız gerekecek.   
