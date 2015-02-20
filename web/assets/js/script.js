(function(){

    $(document).ready(function(){

        /*
         * Toastr
         * Notification plugin
         */
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "onclick": null,
            "showDuration": "400",
            "hideDuration": "1000",
            "timeOut": "7000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }

        // Display errors if present
        $('.notification').each(function(index){
            toastr[$(this).data('type')]( $(this).text() );
        });

    });

})();

