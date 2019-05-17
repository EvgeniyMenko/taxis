$(function() {
     $('form').submit(function(e) {
       var $form = $(this);
       $.ajax({
         type: $form.attr('method'),
         url: $form.attr('action'),
         data: $form.serialize()
       }).done(function(response) {
    	   
    	   var stringified = JSON.stringify(response);
           var json = JSON.parse(stringified);
           if(json){
       	$('#resultLogin').text(json["unknown"]);

       	$('#failRegistr').text(json["fail"]);
           }else{
       	 window.location.href = "/TaxisProject/home";}
          	console.log('succes');
        }).fail(function() {
         console.log('fail');
       });
      
       e.preventDefault(); 
     });
   });