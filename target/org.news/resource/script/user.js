//存放处理与User相关的操作

var user={
    URL:{
        login:function(username,password){
            return '/user/'+username+'/'+password+'/login';
        }
    },

    Login:{
       Submit:function () {
            $('#submit').click(function () {
                var inputUsername = $('#username').val();
                var inputPassword=$('#password').val();

                if (inputUsername&&inputPassword) {
                    //电话写入cookie(7天过期)
                    $.get(user.URL.login(inputUsername,inputPassword),{},function (result){
                        if(result&&result['success']){
                            var users=result['data'];
                            //时间判断 计时交互
                            $.cookie('user', users, {expries: 7, path: '/'});
                            window.location.href("http://localhost:8080/user/index.html");
                            alert('result='+result);
                            alert("funck2");
                            console.log('result='+result);
                        }else {
                            console.log('result='+result);
                            alert(result['errMes']);
                            alert("fuck");
                            window.location.href("http://localhost:8080/user/login1.html");
                    }
                    });
                    //window.location.reload();
                } else {
                    //有问题不能够输出错误信息
                    $('#killPhoneMessage').hide().html("<label>用户或者密码不能为空</label>").show(200);
                }
            });
        }
    },


}