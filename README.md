1)public class MelodyNote implements Iterable<Song> - класс, хранящий экземпляры класса Song (Нотная тетрадь, содержащая песни)

ПОЛЯ:

•ArrayList<Song> songs - список, содержащий экземпляры класса Song(спиок песен)
  
•boolean isOpen - логическая переменная, которая отражает статус тетради: закрыта или открыта
(!добавлять песни в songs можно только в том случае, если isOpen = true (т.е когда тетрадь открыта)!)
  
КОНСТРУКТОР:

•MelodyNote() - при создании тетради, инициализируется спиок songs; isOpen = false(т.е по-умолчанию тетрадь закрыта)

МЕТОДЫ:

•void open() - метод, открывающий тетрадь

•ArrayList<Song> getSongs() - метод, возвращающий список песен
  
•Iterator<Song> iterator() - метод, возвращающий итератор(тетрадь становится открытой isOpen = true)
ВСПОМОГАТЕЛЬНЫЙ КЛАСС:
  
•private class GetIterator implements Iterator<Song> - итератор для списка песен(экземпляр класса создается в методе iterator())
  
--------------------------------------------


2)public class Song implements Iterable<Note> - класс, хранящий экземпляры класса Note (Песня, содержащая ноты)
  
ПОЛЯ:

•ArrayList<Note> notes - список, содержащий экземпляры класса Note(спиок нот)
  
•MelodyNote parent - ссылка на родительскую тетрадь
  
КОНСТРУКТОР:

•Song() - при создании песни, инициализируется спиок notes; parent = null(по-умолчанию у пессни нет родительской тетради)

МЕТОДЫ:

•void add(Note note) - добавляет в список notes ноту

•void add(Note[] notes) - добавляет в список notes массив нот

•ArrayList<Note> getNotes() - возвращает список нот(notes)
  
•MelodyNote addSong(Song song2) - добавляет песню в нотную тетрадь, если она существует; иначе создает новую нотную тетрадь, куда помещает 2 песни(this и song2). У Только что добаленных песен инициалируется поле parent.

•float compair(Song song2) - сравнивает кол-во нот в текущей песни и кол-во нот в песни song2

•void play() - выводит песню на экран(mood = major - большие буквы; mood = minor - маленькие буквы)

•changeMood(MusicalMood mood) - меняет лад от начало песни и до конца

•changeMood(MusicalMood mood, int start) - меняет лад от позиции = start и до конца

•changeMood(MusicalMood mood, int start, int end) - меняет лад от позиции = start до позиции = end

•Iterator<Note> iterator() - метод, возвращающий итератор
  
ВСПОМОГАТЕЛЬНЫЙ КЛАСС:

•private class GetIterator implements Iterator<Note> - итератор для списка нот(экземпляр класса создается в методе iterator())
  
--------------------------------------------


3)public class Note - класс, отвечающий за Ноту

ПОЛЯ:

•NoteSign sign - знак

•MusicalMood mood - лад

КОНСТРУКТОР:

•Note(NoteSign sign) - создает ноту, у которой знак = sign(по-умолчанию mood = major)

•Note(NoteSign sign, MusicalMood mood) - создает ноту, у которой знак = sign, а лад = mood

МЕТОДЫ:

•float compair(Note note) - сравнивает ноты.  нота правее больше ноты левее, при одинаковой позиции - больше та, у которой лад мажор, иначе равны.(ДО<РЕ<МИ<ФА<СОЛЬ<ЛЯ<СИ)

•void setMusicalMood(MusicalMood mood) - меняет лад у ноту на mood

•MusicalMood getMusicalMood() - возвращает лад у ноты

•NoteSign getNoteSign() - возвращает знак у ноты
  
--------------------------------------------


4)public class Page extends Song - СТРАНИЦА. Этот класс наследуется от класса Song, но содержит ограниченное кол-во нот, номер страницы, а также ссылки на следующую и предыдущую страницы

ПОЛЯ:

•int countNontesOnPage - Кол-во нот на странице

•static int numOfPages = 1 - кол-во страниц

•private int numberOfPage - номер страницы

•private Page next - следующая страница

•private Page prev - предыдущая страница



КОНСТРУКТОР:

•Page(int countNontesOnPage) - создается страница и указывается кол-во нот на странице, а также задается номер самой страницы

МЕТОДЫ:

•setNextPage(Page next) - устанавливает ссылку на след. страницу

•public Page getNextPage() - возвращает ссылку на след. страницу

•setPrevPage(Page prev) - устанавливает ссылку на пред. страницу 

•public Page getPrevPage() - возвращает ссылку на пред. страницу

•int getNumOfPages() - возвращает кол-во страниц

•int getNumberOfPage() - возвращает номер страницы

•getСountNontesOnPage() - возвращает кол-во нот на странице

•void play() - выводит содержимое страницы на экран
  
--------------------------------------------


5)public class Convertor - класс, конвертирующий песню в страницы с нотами

МЕТОДЫ:

•ArrayList<Page> convertToPages(Song song, int countNontesOnPage) - возвращает список страниц на основе переданной песни.
    
--------------------------------------------


enum NoteSign{ DO, RE, MI, FA, SOL, LYA, SI } - перечисление знаков (ДО; РЕ; МИ; ФА; СОЛЬ; ЛЯ; СИ)

enum MusicalMood{ major, minor } - перечисление ладов (мажор, минор)
