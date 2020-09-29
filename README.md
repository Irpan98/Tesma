# **Knowledge &amp; Experience Questions**

**Nomor 1.**  **Apa saja library Android yang sering atau biasa anda pakai? Jelaskan kegunaannya bagi**
**anda.**

Berikut daftar library yang saya sering gunakan dalam development android

**Network**

1. Retrofit, untuk mengambil data dari internet
2. Logging-interceptor, untuk menampilkan log retrofit pada logcat

**DataBase**

Room, menyimpan data pada android

**UI**

1. Glide, Untuk Menampilkan Image , saya gunakan untuk menampikan gambar. Terlebih gambar yang membutuhkan _cropcircle_
2. SpinKit, UI loading yang lebih menarik, saya gunakan untuk menampikan loading yang lebih menarik dibandingkan menggunakan _progressbar_ ataupun yang lainnya
3. Shimmer, UI loading seperti facebook , UI saya gunakan ketika menampilkan data RecyclerviewView
4. Material Design, Membuat tapilan UI componen lebih menarik. Komponen yang saya sering gunakan adalan EditText, button, text, dan juga fab
5. AndroidX Navigation, Mempermudah dalam perpindahan activity dan juga mempermudah kodingan.

**Library already Available in Android**

1. RecyclerView, Saya gunakan untuk menampilkan data yang banyak
2. ViewModel, Sangat berguna untuk mempertahankan data dari fragment atau activity yang telah ter &quot;_destroy_&quot;
3. LiveData, Mempermudah implementasi MVVM, saya gunakan untuk mengamati data dari Model

**Library yang pernah saya gunakan, tetapi tidak terlalu sering**

1. Lottie, Untuk menampilkan animation di
2. Fast Android Networking, Untuk mengakses internet, hanya sempat mencoba
3. Picasso, Beberapa kali mencoba picasso, ketika mendapatkan masalah dengan placeholder pada Glide
4. Motion Layout, Terakhir saya coba masih beta, saya gunakan untuk menampilkan animasio transistion
5. RxJava, Hanya mencoba mengambil data dari retrofit dan mengembalikan ke View. Namun belum explorer kelebihan RXJava

**API with Library**

1. Google Maps, menampilkan Map
2. MapBox, menampilkan map dan banyak fitur yang free
3. Firebase, untuk penyimpanan data internet aplikasi

**Nomor 2.**  **Apakah anda menggunakan prinsip clean code atau design pattern untuk project**
**Android anda? Jelaskan penerapan clean code atau design pattern yang biasa anda**
**gunakan dan manfaatnya untuk anda.**

Untuk Saat ini saya masih menggunakan Architecture MVVM Android dan Repository Pattern. Alasan Menggunakan MVVM, dikarenakan mempermudah dalam develpoment Aplikasi. Menurut saya, membuat code yang dapat mudah dibaca adalah satu hal yang menjadi keharusan. Dengan MVVM code akan lebih mudah dibaca, mudah dimaintance, dan juga mudah untuk penambahan fitur.

Untuk Saat ini penggunakan MVVM saya juga belum dikatan sempurna dikarenakan masih membutuhkan banyak pengamalam. Tetapi untuk saat ini kebanyakan project saya sudah menggunakan MVVM dikarekan lebih mudah dibaca dibandikan sebelumnya. Untuk Clean Architecture. Saat ini masih dalam tahap belajar. Sejauh saya tahu clean artictectur dapat digabungkan dengan MVVM.

# **ANALISA**

**API**

List api - [https://dot-android-internship-test.web.app/](https://dot-android-internship-test.web.app/)

1. Place - [https://dot-android-internship-test.web.app/place.json](https://dot-android-internship-test.web.app/place.json)
  1. Titile and sub title
  2. Data
    1. Id, title, content,
    2. Type
      1. Image -\&gt; images
      2. Multiple -\&gt; media
2. Gallery - [https://dot-android-internship-test.web.app/gallery.json](https://dot-android-internship-test.web.app/gallery.json)
  1. caption
  2. Thumnail - box
  3. Image – rectangle
3. User – https://dot-android-internship-test.web.app/user.json
  1. Id, username, fullname, email, phone, avatar

**Demo App**

1. LoadingScreen
2. MainActivity
  1. BottomNav
  2. BottomNav Auto Hide
  3. List Fragment
    1. Loading
    2. Appbar different font
    3. Appbar autohide
    4. App bar back to list fragment
    5. Header
    6. List
      1. Item
        1. Title
        2. subTitle
        3. Image (can multiple)
        4. Image Placeholder
      2. Multiple image can horizontal scroll
  4. Detail List Fragment
    1. Navigation Animation
    2. Appbar different font
    3. Appbar back button to List Fragment
    4. Still part of ListFragment
    5. Slide image (seperti web)
  5. Gallery Fragment
    1. App bar back to list fragment
    2. Appbar different font and back button
    3. Gridview
  6. Detail Gallery
    1. Item
      1. Image
      2. Title
    2. Appbar font
    3. Appbar back button to List Fragment
  7. Profile Fragment
    1. Photo with circle
    2. Name
    3. Fullname
    4. Email
    5. Phone number
    6. imagePlaceholder when no internet
  8. App Support
    1. Support landscape and portrait

# **APP REPORT**

Berikut Hasil dari Aplikasi yang saya buat dalam batas waktu 2 x 24 jam, sesuai batas yang diberikan. Dan juga sesuai tujuan dari test ini bahwa membuat aplikasi android sesuai aplikasi demo.

**App Features**

1. List Place Screen
2. Gallery Screen
3. Detail Tempat Screen
4. Detail Gallery Screen
5. User Data Screen
6. Loading Screen

**Code Used**

Untuk berusaha membuat aplikasi yang salam persis dengan demo App. Berikut library, code atau fitur, yang saya gunakan.

1. Navigation
2. Appbar Auto Hide
3. Font
4. Loading Screen
5. Padding 10dp
6. RecyclerView
7. RecyclerView inside RecyclerView
8. Bottom App Bar
9. Bottom App Bar Auto Hide
10. ProgressBar Loading
11. Title text = 16 sp , bold
12. Placeholder image
13. Slide image
14. Grid View
15. Grid Auto Resize

Berikut yang saya gunakan pada bagian yang saya improve (karena saya tidak tau fitur yang diguankan Demo App)

1. Retrotit
2. Live Data
3. ViewModel
4. Repository Pattern
5. MVVM
6. Picasso dan Glide

**Proses Development Aplikasi Tesma**

Berikut proses pengembakan aplikasi tesma dalam waktu 2 x 24 Jam.

1. Tahap Pertama - Analisa
  1. Analisa Demo App
  2. Analisa API
  3. Analisa Kebutuhan Library
2. Tahap Kedua – Development phase 1
  1. Initialize Project
  2. Setup Network from App
  3. Can Show List Place
  4. Can Show Gallery
  5. Can Show User Data
  6. Can Show Detail Place
  7. Can Show Detail gallery
3. Tahap 3 – Development Phase 2
  1. Polish UI All Fragment
  2. Add Loading Screen
4. Tahap 4 – Development last Phase
  1. Find bug
  2. Fix bug
  3. Clean up code