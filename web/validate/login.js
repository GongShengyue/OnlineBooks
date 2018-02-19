$(function(){
    $("#loginForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            aid:{
                required:true
            },
            password:{
                required:true,
                rangelength:[3,12]
            }
        }
    })
});