
function checkedRadioBeforeSubmit(){

    var conditionTermsAndConditions = false;
    var conditionAddress = false;
    var conditionPayementMethod = false;

    if (document.getElementById('addresses').checked){
        conditionAddress = true
        if (document.getElementById('DirectBank').checked || document.getElementById('Paypal').checked){
            conditionPayementMethod=true;
            if(document.getElementById('termsAndConditions').checked ){
                conditionTermsAndConditions= true;
            }
        }
    }





    if(conditionAddress === false) {
        alert('please select one address');
        return event.returnValue = false;
    }
    if(conditionPayementMethod === false){
        alert('Please enter the payment method.');
        return event.returnValue = false;
    }
    if(conditionTermsAndConditions === false){
        alert('Please read and accept the terms and conditions');
        return event.returnValue = false;
    }

    if (conditionAddress && conditionTermsAndConditions && conditionPayementMethod)
        return event.returnValue = true;


    return event.returnValue = false;
}



    var myButton = document.getElementsByName('passwordShow');
    var myInput = document.getElementsByName('pass');
    myButton.forEach(function(element, index){
        element.onclick = function(){
            'use strict';

            if (myInput[index].hasAttribute('hidden')) {
                myInput[index].removeAttribute('hidden');
                element.firstChild.textContent = 'Hide';

            } else {
                // myInput[index].setAttribute('hidden');
                myInput[index].hidden = true;
                element.firstChild.textContent = 'Show';

            }
        }
    })






