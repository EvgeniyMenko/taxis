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
		            if(json["error"]!=null){
		            $('#result').text(json["result"]);
		            }else{
	                var car =json["car"];
	                var carModel =json["carModel"];
	                var cost =json["cost"];
	                var fuelConsumption =json["fuelConsumption"];
	                var acceleration =json["acceleration"];
	                var maxSpeed =json["maxSpeed"];
	                var priceForOneMinute =json["priceForOneMinute"];
	                var classCar =json["classCar"];
	                var id =json["id"];
	              
		        	$('#result').text(json["result"]);
		        	
		        	$("#selectBox :selected").remove();
		       $("#selectBox").append($("<option></option>").attr("data-car",car)
		    		   .attr("data-carModel",carModel)
		    		   .attr("data-cost",cost)
		    		   .attr("data-fuelConsumption",fuelConsumption)
		    		   .attr("data-acceleration",acceleration)
		    		   .attr("data-maxSpeed",maxSpeed)
		    		   .attr("data-priceForOneMinute",priceForOneMinute)
		        	    .attr("data-id", id).text(classCar+","+car+","+carModel));
		       $('#selectBox option:last').prop('selected', true);
		      console.log('succes');
		            }
		         }).fail(function() {
		          console.log('fail');
		        });
		       
		        e.preventDefault(); 
		      });
		    });
		$(function() {
			  $('select').on('change', function() {
			        car = $('select option:selected').attr('data-car');
			        carModel = $('select option:selected').attr('data-carModel');
			        cost = $('select option:selected').attr('data-cost');
			        fuelConsumption = $('select option:selected').attr('data-fuelConsumption');
			        acceleration = $('select option:selected').attr('data-acceleration');
			        maxSpeed = $('select option:selected').attr('data-maxSpeed');
			        priceForOneMinute = $('select option:selected').attr('data-priceForOneMinute');
			        id = $('select option:selected').attr('data-id');
$('input[name="car"]').val(car);
$('input[name="carModel"]').val(carModel);
$('input[name="cost"]').val(cost);
$('input[name="fuelConsumption"]').val(fuelConsumption);
$('input[name="acceleration"]').val(acceleration);
$('input[name="maxSpeed"]').val(maxSpeed);
$('input[name="priceForOneMinute"]').val(priceForOneMinute);
$('input[name="id"]').val(id);

 });
			});
		