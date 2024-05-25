Andrej Aleksovski 213100

2.

![Screenshot 2024-05-24 142253](https://github.com/Alekso93/SI_2024_lab2_213100/assets/107583467/437a7763-f35d-4b42-9ffa-311d9b1553e7)


3.Броj на условни изрази + 1:

  Бројот на условни изрази = 9
  Цикломатската комплексност = 9 + 1 = 10

4.

![Screenshot 2024-05-24 210946](https://github.com/Alekso93/SI_2024_lab2_213100/assets/107583467/1ec4e1c4-520d-48e2-bb02-2384873527e8)


.Тестови според Every Branch критериумот

Тест 1:
Влезни податоци: List<Item> list = {item1, item2, item3}, payment = 50
Каде:
Item item1 = new Item("testname1", "12345", 20, 10);
Item item2 = new Item("testname2", "54321", 60, 20);
Item item3 = new Item("testname3", "17542", 40, 30);
Овој тест е рендом одбран тест, чисто за да се видат кои гранки ќе останат неизминати.

Тест 2:

Влезни податоци: List<Item> list = {new Item(null, null, 300, -10)}, payment = 5000
Овој тест е заради изминување на гранките D-E, E-F, F-M, M-S, односно кога името е null и баркодот е null, при што се фрла исклучок.

Тест 3:

Влезни податоци: List<Item> list = {new Item("item", "01234", 400, 10)}, payment = 5000
Овој тест е заради изминување на гранките N-O, O-C2, P-Q, Q-S, односно исполнување на условите (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'), и потоа (sum <= payment).

Тест 4:

Влезни податоци: Кога листата е null, а вредноста на payment може да биде било која, бидејќи овој тест е за гранките A-B и B-S, каде се фрла исклучок ако листата е еднаква на null.

Тест 5:

Влезни податоци: List<Item> list = {new Item("item", "01234", 400, -10)}, payment = 5000

Тест 6:

Влезни податоци: List<Item> list = {new Item("item", "!1234", 400, -10)}, payment = 5000


5.

![Screenshot 2024-05-24 150113](https://github.com/Alekso93/SI_2024_lab2_213100/assets/107583467/0b39a1a6-4720-416e-bf19-044ef979187d)


Условот има три подуслови:
A: item.getPrice() > 300
B: item.getDiscount() > 0
C: item.getBarcode().charAt(0) == '0'
За Multiple Condition тестирање, треба да се тестираат сите комбинации на вистинити и лажни вредности на подусловите (2^3 = 8 комбинации):
Табела на тест случаи:
