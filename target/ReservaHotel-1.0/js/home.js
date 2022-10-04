$(document).ready(function () {
    $("#form-register").submit(function (event) {

        event.preventDefault();
        registerHabitacion();
    });


});

function registerHabitacion() {

    let id_habitacion = $("#input-habitacion").val();
    let id_habitacionConfirmacion = $("#input-habitacion-repeat").val();
    let piso = $("#input-piso").val();
    let tipo = $("#input-tipo").val();
    let ciudad = $("#input-ciudad").val();
    let precio_dia = $("#input-precio_dia").val();
    let novedad = $("#input-novedad").prop("checked");

    if (id_habitacion == id_habitacionConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletHabitacionRegister",
            data: $.param({
                id_habitacion: id_habitacion,
                tipo: tipo,
                piso: piso,
                ciudad: ciudad,
                precio_dia: precio_dia,
                novedad: novedad
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult !== false) {
                    $("#register-error").addClass("d-none");
                    let id_habitacion = parsedResult["id_habitacion"];
                    document.location.href = "home.html?id_habitacion=" + id_habitacion;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}
