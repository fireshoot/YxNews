/**
 * author by yangxin
 */
function checkname() {
    //原生js的获取节点的方式
    username = document.getElementById("username");
    tip = document.getElementById("tip_name");
    //正则表达式，表示用户名可以是大小写字母数据，长度6-20位
    reg = /^[a-zA-Z0-9]{6,20}$/;
    if (!reg.test(username.value)) {
        tip.innerHTML = "用户为6-20的字符";
        return false;
    } else {
        tip.innerHTML = " ";
        return true;
    }
}

function checkpsd1() {
    password = document.getElementById("password");
    tip = document.getElementById("tip_password");
    reg = /^[a-zA-Z0-9]{6,20}$/;

    if (!reg.test(password.value)) {
        tip.innerHTML = "密码为6-20的字母或者数字组成";
        return false;
    } else {
        tip.innerHTML = " ";
        return true;
    }
}

function checkpsd2() {
    password = document.getElementById("password");
    password_new = document.getElementById("password1");
    tip = document.getElementById("tip_password1");
    reg = /^[a-zA-Z0-9]{6,20}$/;

    if (password.value != password_new.value) {
        tip.innerHTML = "两次密码不一致";
        return false;
    } else {
        tip.innerHTML = " ";
        return true;
    }
}
function Age() {
    age=document.getElementById("age");
    tip = document.getElementById("tip_age");
    reg = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;

    if(!reg.test(age.value)){
        tip.innerHTML = "年龄1-120";
        return false;
    } else {
        tip.innerHTML = " ";
        return true;
    }
}

function checkemail() {
    email = document.getElementById("email");
    tip = document.getElementById("tip_email");
    reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    if (!reg.test(email.value)) {
        tip.innerHTML = "邮件格式不正确";
        return false;
    } else {
        tip.innerHTML = " ";
        return true;
    }
}

function forgetcheckAll() {

    if (checkname() && checkpsd1()  && checkemail()) {

        return true;

    } else {
        alert("不能为空");
        return false;
    }
}



function checkAll() {

    if (checkname() && checkpsd1() && checkpsd2() && checkemail()
        && checkphone() && checkqq()) {

      return true;

    } else {
        alert("不能为空");
        return false;
    }
}
