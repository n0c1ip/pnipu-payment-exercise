<?php

return array(
    array(
        'value'       => 'https://localhost/index.php/payments.php/',
        'title'       => 'checkURL',
        'description' => 'URL(https), на который отправляется запрос «Проверка заказа»',
    ),
    array(
        'value'       => 'https://localhost/index.php/payments.php/',
        'title'       => 'paymentAvisoURL',
        'description' => 'URL(https), на который отправляется запрос «Уведомление об оплате»',
    ),
    array(
        'value'       => 'https://localhost/index.php/payments.php/',
        'title'       => 'successURL',
        'description' => 'URL для кнопки "возврат в магазин" на странице, отображаемой покупателю после успешной оплаты',
    ),
    array(
        'value'       => 'https://localhost/index.php/payments.php/',
        'title'       => 'failURL',
        'description' => 'URL для кнопки "возврат в магазин" на странице, отображаемой покупателю после неуспешной оплаты.',
    ),

    array(
        'value'        => '#100500
100500
#100500 текст комментария
100500 текст комментария
',
        'title'        => 'Назначение платежа',
        'description'  => 'Используйте один из форматов описания заказов для мобильных терминалов
<strong>Указанный в этом поле формат используйте для поля "Назначение платежа" при оплате через <a href="https://kassa.yandex.ru/instruments#mpos" target="_blank">мобильный терминал</a>.</strong>
Если оставить поле пустым, то будет создан подвешенный новый заказ.
',
        'control_type' => waHtmlControl::TEXTAREA,
    ),
);
