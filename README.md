# commons-debug

Класс для поддержки отладка кода. Объяснить на словах трудно, покажу примере.

Пример: <br/>
У меня есть метод `scrollTo` который вызывает `equals` конкретного объекта, и я хочу отладит метод `equals` когда вызывает его метод `scrollTo`. В проекте метод `equals` вызывается из разных местах и разными методами. 

	private void scrollToBlaBla(ItemClickEvent event) {
        grid.scrollTo(event.getItemId(), ScrollDestination.START);
    }

Оберну на метод `scrollToBlaBla` чтобы получит уникальный имя. Написал код внутри метода `equals`, чтобы отловить код когда выполняется метод `scrollTo`.

	public boolean equals(Object o) {
        if (DebugUtils.isCausedMethod("scrollToBlaBla")){
            // Do Something
			...
        }
		...

Внутр блока `if` поставил `Breakpoint`, и я смог отловит код `equals` когда выполнялся метод `scrollTo`. Реализация класса очень простой, и я надеюсь что вам поможет решит вашу проблему. 