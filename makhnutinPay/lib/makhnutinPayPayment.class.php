<?php

class makhnutinPayment extends waPayment implements waIPayment
{


    private $version = '1.3';
    private $order_id;
    private $request;

    public function allowedCurrency()
    {
        return 'RUB';
    }

    public function payment($payment_form_data, $order_data, $auto_submit = false)
    {
        $order_data = waOrder::factory($order_data);
        $view = wa()->getView();
        $view->assign('plugin', $this);
        $view->assign('order', $order_data);
        $view->assign('return_url', $this->getAdapter()->getBackUrl(waAppPayment::URL_SUCCESS));
	$view->assign('sum', $order_data['amount']);
        $view->assign('orderId', $order_data['order_id']);

        return $view->fetch($this->path.'/templates/payment.html');
    }

}
