var main = {
               init : function () {
                   var _this = this;
                   $('#btn-prev).on('click', function () {
                              _this.prev();
                   });
                   $("#btn-next").on('click', function () {
                         _this.next();
                   });
               },
               prev : function () {

                   var data = {

                        pageNumber: $("#title").val()

                   };

                   $.ajax({
                       type : 'GET',
                       url : '/prev',
                       dataType : 'json',
                       contentType : 'application/json; charset=utf-8',
                       data : JSON.stringify(data)
                   }).done(function () {
                       alert('이전');

                   }).fail(function (error) {
                       alert(JSON.stringify(error));
                   })
               },

               next : function () {

                        var data = {

                            pageNumber: $("#title").val()


                        };

                        $.ajax({
                            type : 'GET',
                            url : '/next',
                            dataType : 'json',
                            contentType : 'application/json; charset=utf-8',
                            data : JSON.stringify(data)
                        }).done(function () {

                        }).fail(function (error) {
                            alert(JSON.stringify(error));
                        })
               }
};
main.init();