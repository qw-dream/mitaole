<%--
  Created by IntelliJ IDEA.
  User: qiuwei
  Date: 2020/7/10
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=request.getContextPath()%>/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>iphone 7的30天内回收平均价格3360元-回购网 - 二手数码回收平台</title>
    <meta name="keywords" content="iphone 7 iphone7 7 苹果7 苹果 7"/>
    <meta name="description" content="iphone 7 iphone7 7 苹果7 苹果 7"/>
    <meta name="baidu-site-verification" content="IpuQLFxZiC"/>
    <meta name="chinaz-site-verification" content="081e7651-48c6-4c2f-a569-99321685eab1"/>
    <meta name="mobile-agent" content="format=html5;url=http://m.ihuigo.com/goods/info/21025.html">
    <meta name="applicable-device" content="pc">
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.ihuigo.com/goods/info/21025.html">
    <link href="favicon.ico" type=image/x-icon rel="Icon">
    <link href="css/new_css/global.css" rel="stylesheet" type="text/css">
    <script src="js/new_js/jquery-1.4.2.js" type="text/javascript"></script>
    <script src="js/new_js/new_public.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
    <link href="css/new_css/sub.css" rel="stylesheet" type="text/css">
    <script src="js/public.js" type="text/javascript"></script>
    <script src="js/new_js/menu.js" type="text/javascript"></script>
    <script src="js/new_js/new_goods.js" type="text/javascript"></script>
</head>
<body>
<link rel="stylesheet" type="text/css" href="css/alert_zhe.css"/>
<script type="text/javascript" src="js/alert_zhe.js"></script>
<!--头部--><!--手机回收-->
<div class="recovery">
    <script type="text/javascript">
        $(document).ready(function () {
            $(".new_search_btn").click(function () {
                $(".new_search").slideToggle();
            });
        });
    </script>
    <div class="page2" style="position:relative">
        <div class="new_search_btn" style="position:absolute; left:-40px; top:-11px; cursor:pointer;"><img
                src="images/new_images/search_btn.png" alt="搜索您要评估价格的机型"/></div>

        <div style="height:30px; line-height:30px; font-size:14px;"><a href="">首页</a> &gt;<a
                href="ershoushouji.html">手机</a> &gt;<a href="ershouiphone.html"> iPhone</a> &gt; ${tbPhone.phoneName}
        </div>
        <div class="heat_l">
            <div class="heat_img">
                <img src="${pageContext.request.contextPath}/${tbPhone.phoneImg}" alt="${tbPhone.phoneName}回收价格评估"
                     width="264" height="197"/>
            </div>
            <div class="heat_txt">
                <div class="heat_name"><span>${tbPhone.phoneName}</span></div>
                <dl class="heat_ts">
                    <dd><em>${tbPhone.phonePrice}</em>元<br/>
                        30天内回收最高价
                    </dd>
                    <dt class="clear"></dt>
                </dl>
                <div class="heat_bao"><img src="images/new_images/icon10.gif" alt="${tbPhone.phoneName}回收免费享受第三方理赔服务"/>可免费享受第三方理赔服务
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <script src="js/new_js/morris/raphael-2.1.0.min.js"></script>
        <script src="js/new_js/morris/morris.js"></script>
        <link rel="stylesheet" href="js/new_js/morris/morris.css">

        <div class="heat_r">
            <div class="heat_title"><span>回购价格趋势</span><samp>单位：元</samp></div>
            <div class="heat_pic">
                <div id="graph" style="width:360px; height:210px; margin-top:0px;"></div>
            </div>
            <script>
                var day_data = [
                    {"elapsed": "7", "价格": "${tbPhone.goodFirstPrice}"}
                    , {"elapsed": "8", "价格": "${tbPhone.goodSecondPrice}"}
                    , {"elapsed": "9", "价格": "${tbPhone.goodThirdPrice}"}
                    , {"elapsed": "10", "价格": "${tbPhone.goodForthPrice}"}
                    , {"elapsed": "11", "价格": "${tbPhone.goodFifthPrice}"}
                ];
                Morris.Line({
                    element: 'graph',
                    data: day_data,
                    xkey: 'elapsed',
                    ykeys: ['价格'],
                    labels: ['价格'],
                    parseTime: false
                });
            </script>
        </div>

        <div class="clear"></div>
    </div>
</div>

<!--手机回收-->
<!--评估流程-->
<div id="ahs_trade_body">

    <input type="hidden" id="view" value="goods_info"/>
    <input type="hidden" id="if_show_price" value="1"/>
    <input type="hidden" id="gid" name="gid" value="21025"/>
    <input type="hidden" id="package_id" name="package_id" value="571"/>
    <div id="ahs_property_head">
        <p>开始评估你的手机，只需3步，获得产品精准评估报价</p>
        <!--步骤一-->
        <div class="speed" id="speed1"><img src="images/new_images/step1.gif" alt="第1步评估手机的基本情况"/></div>
        <!--步骤一-->

        <!--步骤二-->
        <div class="speed" id="speed2"><img src="images/new_images/step2.gif" alt="第2步评估手机的功能使用情况"/></div>
        <!--步骤二-->
        <!--步骤三-->
        <div class="speed" id="speed3"><img src="images/new_images/step3.gif" alt="第一步评估手机的外观成色"/></div>
        <!--步骤三-->
    </div>

    <div id="ahs_property_body">
        <!--第一步-->
        <div id="property_step1">
            <dl>

                <c:forEach items="${attrList}" var="attr">

                <dd>
                    <input type="hidden" name="property[]" id="property_${attr.attrId}" value="0"/>

                        <div class="property_title"><h3>${attr.attrName}</h3></div>
                        <ul>
                            <c:forEach items="${attr.information}" var="list">

                            <li class="" onClick="property_click(this,'${list.attrId}','${list.discountId}')" name="sx_child_${list.attrId}">
                                    <div class="pro_div " onclick="first1(${list.attrId},${list.discountId})">
                                        <span class="property_value"><i>${list.valAttrVal}</i><ins>${list.valDesc}</ins></span><span
                                            class="gou"></span>
                                    </div>
                            </li>
                            </c:forEach>
                            <div class="clear"></div>
                        </ul>
                </dd>
                </c:forEach>

                <div id="step1_nav" class="property_nav">
                    <div id="btn_step1_next" class="btn_next">下一步</div>
                </div>
            </dl>
        </div>
        <!--第一步-->

        <!--第二步-->
        <div id="property_step2" class="hide">
            <dl>
                <dd>
                    <div class="property_title">
                        <h3>${tbAttr.attrName}</h3>
                    </div>
                    <ul>
                        <input type="hidden" name="desc_pid[]" value="${attr1.attrId}"/>
                        <input type="hidden" name="desc_id[]" id="desc_id_${attr1.attrId}" value="945"/>
                        <c:forEach items="${tbAttr.information}" var="attr1">

                        <li onClick="item_click(this,'${attr1.attrId}','946','945')" name="mx_child_${attr1.attrId}">
                            <div class="pro_div" onclick="first1(${attr1.discountId},${attr1.discountId})">
                                <span class="property_value"><i>${attr1.valAttrVal}</i><ins>${attr1.valDesc}</ins></span>
                                <span class="gou"></span></div>
                        </li>
                        </c:forEach>


                        <div class="clear"></div>
                    </ul>
                </dd>
            </dl>
            <div id="step2_nav" class="property_nav">
                <div id="btn_step2_back" class="btn_back">< 返回上一步</div>
                <div id="btn_step2_next" class="btn_next">都没问题，跳过 ></div>
            </div>
        </div>
        <!--第二步-->

        <!--第三步-->
        <div id="property_step3" class="hide">

            <dl>
                <c:forEach items="${attrList1}" var="attr2">
                <dd class="" id="pingu_mx_${attr2.attrId}">
                    <input type="hidden" name="desc_pid[]" value="${attr2.attrId}"/>
                    <input type="hidden" name="desc_id[]" id="desc_id_${attr2.attrId}" value="0"/>
                    <div class="property_title"><h3>${attr2.attrName}</h3></div>
                    <ul>
                        <c:forEach items="${attr2.information}" var="list2">
                            <li class="" onClick="item_click(this,'${list2.attrId}','${list2.discountId}')" name="mx_child_${list2.attrId}">
                                <div class="pro_div" onclick="first1(${list2.attrId},${list2.discountId})">
                                    <span class="property_value"><i>${list2.valAttrVal}</i><ins>${list2.valDesc}</ins></span>
                                    <span class="gou"></span></div>
                            </li>
                        </c:forEach>

                        <div class="clear"></div>

                    </ul>
                </dd>
                </c:forEach>

            </dl>


            <div id="step3_nav" class="property_nav">
                <div id="btn_step3_back" class="btn_back">< 返回上一步</div>
                <div id="btn_step3_next" class="btn_next"
                     onclick="prices()">查看价格 >
                </div>
            </div>
        </div>
<%--        onclick="new_show_price('ajax/new_get_pg_price.html','show_price')--%>
        <!--第三步-->
    </div>
</div>
<!--评估流程-->


<!--隐藏的评估描叙选项start-->
<div style="display:none; background-color:#CCCCCC;">
</div>
<!--隐藏的评估描叙选项end-->
<script>

    // var map=new Map();
    var arrPriceid=[];
    arrPriceid[0]=${tbPhone.phoneId}
    function first1(id,id2){
        arrPriceid[id]=id2;
        console.log(arrPriceid);
    }

    var data1={"key":arrPriceid}

    function prices() {
        $.ajax({
            url: "phone/info2",
            type: "post",
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data1),
            success: function (data) {
                //当异步请求对象状态发生改变就会执行本方法
                console.log(data);
                if (data.code == 0) {
                    window.location.href = data.obj;
                } else {
                    alert("查看价格失败~请稍后再试");
                }
            }
        });
    }

    $(document).ready(function () {
        $("#step1_nav .btn_next").bind('click', step1_next);
        $("#step2_nav .btn_next").bind('click', step2_next);
        $("#step2_nav .btn_back").bind('click', step2_back);
        $("#step3_nav .btn_back").bind('click', step3_back);

        $("input[name='property[]']").each(function () {
            $(this).val(0);
        })
        $("#property_step1 input[name='desc_id[]']").each(function () {
            $(this).val(0);
        })
        $("#property_step3 input[name='desc_id[]']").each(function () {
            $(this).val(0);
        })
        $("#pj_ids").val(0);
    })
</script>
<!--[if lte IE 6]>
<script src="js/new_js/png.js" type="text/javascript"></script>
<script type="text/javascript">
    DD_belatedPNG.fix('img,.banner ul, li, dl, dt, dd, span, em, div, i, samp, a, b, .kuang');
</script>
<![endif]-->
</body>
</html>
