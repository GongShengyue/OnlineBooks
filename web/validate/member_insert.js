$(function(){
    $("#insertForm").validate({
        debug:true,
        submitHandler:function(form){
            form.submit(); // 表示采用手工提交
        },
        rules:{
            mid:{
                required:true
            },
            name:{
                required:true

            },
            age:{
                required:true,
                digits:true
            },
            phone:{
                required:true
            },
            note:{
                required:true;
            }

        }
    })
});
