package pe.edu.savbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

//    private static final Logger log = LoggerFactory.getLogger(UsuariosController.class);

    
    @RequestMapping("/")
    public String index() {
        return "prueba de rest";
    }
//    @Autowired
//    private UsuariosService usuariosService;

//    @PostMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Autenticar usuario", notes = "Autentica a un usuario con su contraseña.", nickname = "autenticarUsuario")
//    @ApiResponses({ @ApiResponse(code = 200, message = "Mensaje de respuesta") })
//    public ResponseEntity<RestResponse> autenticarUsuario(@RequestBody Credentials credenciales,
//            HttpServletRequest httpServletRequest) throws FirebaseAuthException {
//        log.info("=== Inicio metodo autenticarUsuario ===");
//
//        String token = usuariosService.autenticarUsuario(credenciales, httpServletRequest.getRemoteAddr());
//
//        log.info("=== Fin metodo autenticarUsuario ===");
//        return new ResponseEntity<RestResponse>(RestResponseFactory.crearRestResponse("Autenticado correctamente",
//                "El usuario se puede autenticar con firebase mediante el custom token dentro del campo \"data\"",
//                RestResponse.AUTENTICADO_EXITOSAMENTE, null, null, token), HttpStatus.OK);
//    }
//
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Actualizar token de usuario", notes = "Actualiza el token de usuario del usuario actual.", nickname = "actualizarTokenUsuario")
//    @ApiResponses({ @ApiResponse(code = 200, message = "Mensaje de respuesta") })
//    public ResponseEntity<RestResponse> actualizarTokenUsuario(Authentication auth) throws FirebaseAuthException {
//        log.info("=== Inicio metodo actualizarTokenUsuario ===");
//
//        EdanAuthToken token = (EdanAuthToken) auth;
//        FirebaseToken firebaseToken = (FirebaseToken) (token.getCredentials());
//        usuariosService.actualizarTokenUsuario(firebaseToken.getUid());
//
//        log.info("=== Fin metodo actualizarTokenUsuario ===");
//        return new ResponseEntity<RestResponse>(RestResponseFactory.crearRestResponse("Token actualizado", null,
//                RestResponse.MODIFICADO_EXITOSAMENTE, null), HttpStatus.OK);
//    }
//
//    @PreAuthorize("hasAuthority(@permisos.getPermiso('usuarios.leer'))")
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Listar los usuarios", notes = "Lista los usuarios existentes", nickname = "listarUsuarios")
//    @ApiResponses({ @ApiResponse(code = 200, message = "Lista de usuarios dentro del campo \"data\"") })
//    public ResponseEntity<RestResponse> listarUsuarios(
//            @ApiParam(value = "La página inicial para la lista de usuarios", allowableValues = "range[0, infinity]", defaultValue = "0") @RequestParam(value = "start", defaultValue = "0") int start,
//            @ApiParam(value = "La cantidad de usuarios por página", allowableValues = "range[1, infinity]", defaultValue = "10") @RequestParam(value = "length", defaultValue = "10") int length)
//            throws FirebaseAuthException {
//        log.info("=== Inicio metodo listarUsuarios ===");
//
//        start = start < 0 ? 0 : start;
//        length = length < 1 ? 10 : length;
//
//        MutableWrapper<Boolean> hayMasPaginas = new MutableWrapper<Boolean>(false);
//        List<Usuario> out = usuariosService.listarUsuarios(start, length, hayMasPaginas);
//
//        log.info("=== Fin metodo listarUsuarios ===");
//        return new ResponseEntity<RestResponse>(
//                RestResponseFactory.crearRestResponse(RestResponse.LEIDO_EXITOSAMENTE, hayMasPaginas.getValue(), out),
//                HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Agregar suscripción al usuario", notes = "Agrega una suscripción al usuario autenticado", nickname = "agregarSuscripcionUsuario")
//    @PostMapping(value = "/yo/suscripciones", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<RestResponse> suscribirPushNotification(
//            @ApiParam(value = "El detalle de la suscripción a agregar") @RequestBody Suscripcion suscripcion) {
//        return null;
//    }
}