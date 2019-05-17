$(function() {
			  $('select').on('change', function() {
			       
			        id = $('select option:selected').attr('data-id');

                  $('input[name="id"]').val(id);

});
			});
		
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
		        	$('#result').text(json["result"]);
		        	
	             
		           
		        	console.log('succes');
		         }).fail(function() {
		          console.log('fail');
		        });
		       
		        e.preventDefault(); 
		      });
		    });
		