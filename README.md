# lab6_pnp11 PnP11
#Kacper Chrostowski

Dodałem:
-

- Klase abstract na podstawie której zrobimy klase kulki(Creature.java)

- Zacząłem robić okno animacji na którym będzie się odbywała cała akcja(AnimPanel.java)

- Dodałem okno animacji w MainWindow

- Dodałem metodę w MainWindow która skaluje anim panel do wielkości okna animacji.
  Problem jest taki że będzie to przerywać animacje(musiałem dodać wywołanie ClearAll bo kulki i tak będą znikać wiec je zniszcze żeby nie śmiecić) więc trzeba się temu przyjrzeć

UWAGA:
-

- w anim panel trzeba dopracować animowanie. w main window macie dwa guziki do dodawania figury do tablicy i do startowania jej animacji.

- potem dorobie rescale ładny bo coś dół ucina

#Arek Pytka 

- Dodałem klase SwingElements dzięki której można tworzyć predefiniowane elementy biblioteki Swing. Jak coś trzeba to zmieniajcie lub dodawajcie :)

#Mateusz Skuza

-Dodałem przycisk umożliwiający zmianę koloru kulki.

-Dodałem przycisk umożliwiający generowanie losowego koloru wyświetlającej się kulki 

#Andrzej Kwaśniewski

- Dodałem przycisk wyjścia z aplikacji

#Kacper Krupiński

- Dodanie losowego "spawnu" obiektów
- Dodanie losowej rozszeszalności obiektów
- Poprawnienie ustawnienia kanwy i guzików (dalej drobne problemy)
- Lekka refactoryzacja kodu

#Piotr Rachwalik

- Dostosowałem poożenie przycisków w zależności od skalowania
- Naprawiłem błąd skalowania dla okna animacji gdzie działy się dziwne błędy - teraz skaluje się poprawnie ale niestety przy skalowaniu resetuje się animacja (nie wiem czy da się zrobić inaczej, ale jak ktoś potrafi to mozna to zmienić)

#Michał Salamon

- Dodałem pole tekstowe, które ustawia wielkość kulki przy jej dodaniu do listy

#Karol Rakicki

- Dodałem przycisk reset
