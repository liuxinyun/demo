<!DOCTYPE html>
<html lang="en">
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
        .tg .tg-sh4c{text-align:center;vertical-align:top}
        .tg .tg-baqh{text-align:center;vertical-align:top}
        .tg .tg-h0x1{text-align:center}
    </style>
<body>

<div>
    <div></div>
    <div>
        <p><span>您好，</span></p>
    </div>
</div>

<div style="margin-left : 30px">
    <div></div>
    <div>
        <p><span>${emailHead}</span></p>
    </div>
</div>

<div style="margin-left : 30px;margin-top : 30px;">
    <table class="tg">
        <tr>
            <th class="tg-baqh">订单号</th>
            <th class="tg-baqh" colspan="3">${orderNo}</th>
        </tr>
        <tr>
            <td class="tg-sh4c">机构名称</td>
            <td class="tg-sh4c" colspan="3">${institutionName}</td>
        </tr>
        <tr>
            <td class="tg-sh4c">商品金额</td>
            <td class="tg-sh4c" colspan="3">${goodsAmount}元</td>
        </tr>
        <tr>
            <td class="tg-baqh">收货人</td>
            <td class="tg-baqh" colspan="3">${consigneeName}</td>
        </tr>
        <tr>
            <td class="tg-sh4c">手机号码</td>
            <td class="tg-sh4c" colspan="3">${consigneePhone}</td>
        </tr>
        <tr>
            <td class="tg-baqh">收货地址</td>
            <td class="tg-baqh" colspan="3">${consigneeAddress}</td>
        </tr>
        <tr>
            <td class="tg-h0x1" rowspan="${skuList?size + 1}">商品清单</td>
            <td class="tg-sh4c">商品名称</td>
            <td class="tg-sh4c">条形码</td>
            <td class="tg-sh4c">数量</td>
        </tr>
        <#list skuList as sku>
            <tr>
                <td class="tg-baqh">${sku["goodsName"]}</td>
                <td class="tg-baqh">${sku["barcode"]}</td>
                <td class="tg-baqh">${sku["num"]}</td>
            </tr>
        </#list>
    </table>

</div>

<div style="margin-left : 30px;margin-top : 50px;">
    <div></div>
    <div>
        <p><span>请尽快安排印刷厂印刷，并及时将运单号录入订单系统。</span></p>
    </div>
</div>

</body>
</html>