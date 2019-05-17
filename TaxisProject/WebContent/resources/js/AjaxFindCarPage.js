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
		            if(json["result"]!=null){
		            	$('#result').text(json["result"]);
		            }else {
		          
		            var url = "/TaxisProject/home?action=findCarResult";
		            var minSpeed =json["minSpeed"];
		            var maxSpeed =json["maxSpeed"];
		            var minAcceleration =json["minAcceleration"];
		            var maxAcceleration =json["maxAcceleration"];
		            var form = $('<form action="' + url + '" method="post">' +
		              '<input type="text" name="minSpeed" value="' + minSpeed + '" />' +
		              '<input type="text" name="maxSpeed" value="' + maxSpeed + '" />' +
		              '<input type="text" name="minAcceleration" value="' + minAcceleration + '" />' +
		              '<input type="text" name="maxAcceleration" value="' + maxAcceleration + '" />' +
		              '<input type="text" name="forward" value="true" />' +
		              '</form>');
		            $('body').append(form);
		            form.submit();
		          }
		            
		      
	           console.log('succes');
		        	  
		         }).fail(function() {
		          console.log('fail');
		        });
		       
		        e.preventDefault(); 
		      });
		    });