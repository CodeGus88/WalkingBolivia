package com.codegus.walkingbolivia.models;

public class Value {

    public static final int CREATE =1001;
    public static final int UPDATE =1002;
    public static final int DELETE =1003;

    // Departamentos de Bolivia [0->Departamento, 1->Capital]
    // SUR AMÉRICA (?->1)
    public static final String [] BOLIVIA = {"Bolivia", "Sucre"};
    // BOLIVIA (9)
    public static final String [] BENI = {"Beni", "Trinidad"};
    public static final String [] CHUQUISACA = {"Chuquisaca", "Sucre"};
    public static final String [] COCHABAMBA = {"Cochabamba", "Cochabamba"};
    public static final String [] LA_PAZ = {"La Paz", "La Paz"};
    public static final String [] ORURO = {"Oruro", "Oruro"};
    public static final String [] PANDO = {"Pando", "Cobija"};
    public static final String [] POTOSI = {"Potosí", "Potosí"};
    public static final String [] SANTA_CRUZ = {"Santa Cruz", "anta Cruz de la Sierra"};
    public static final String [] TARIJA = {"Tarija", "Tarija"};



    /**
    // Provinvias de los departamentos [0->Provincia, 1->Capital]
    // BENI (8)
    public static final String [] BEN_01_CERCADO = {"Cercado", "San Javier"};
    public static final String [] BEN_02_ANTONIO_VACA_DIEZ = {"Antonio Vaca Díez", "Riberalta"};
    public static final String [] BEN_03_MARISCAL_JOSE_BALLIVIAN_SEGUROLA = {"Mariscal José Ballivián Segurola", "Santos Reyes"};
    public static final String [] BEN_04_YACUMA = {"Yacuma", "Santa Ana de Yacuma"};
    public static final String [] BEN_05_MOXOS = {"Moxos", "San Ignacio de Moxos"};
    public static final String [] BEN_06_MARBAN = {"Marbán", "Loreto"};
    public static final String [] BEN_07_MAMORE = {"Mamoré", "San Joaquín"};
    public static final String [] BEN_08_Itenez = {"Itenez", "Magdalena"};
    // CHUQUISACA (10)
    public static final String [] CHU_01_OROPEZA = {"Oropeza", "Sucre"};
    public static final String [] CHU_02_AZURDUY = {"Azurduy", "Azurduy"};
    public static final String [] CHU_03_ZUDANES = {"Zudañes", "Villa Zudáñez"};
    public static final String [] CHU_04_TOMINA = {"Tomina", "Padilla"};
    public static final String [] CHU_05_HERNANDO_SILES = {"Hernando Siles", "Monteagudo"};
    public static final String [] CHU_06_YAMPARAEZ = {"Yamparaez", "Tarabuco"};
    public static final String [] CHU_07_NOR_CINTI = {"Nor Cinti", "Camargo"};
    public static final String [] CHU_08_SUR_CINTI = {"Sur Cinti", "Camataqui"};
    public static final String [] CHU_09_BELISARIO_BOETO = {"Belisario Boeto", "Villa Serrano"};
    public static final String [] CHU_10_LUIS_CALVO = {"Luis Calvo", "Villa Vitorio Guzmán"};
    // COCHABAMBA (16)
    public static final String [] COC_01_ARANI = {"Arani", "Arani"};
    public static final String [] COC_02_ESTEBAN_ARCE = {"Esteban Arce", "Tarata"};
    public static final String [] COC_03_ARQUE = {"Arque", "Arque"};
    public static final String [] COC_04_AYOPAYA = {"Ayopaya", "Villa Independencia"};
    public static final String [] COC_05_CAMPERO = {"Campero", "Aiquile"};
    public static final String [] COC_06_CAPINOTA = {"Capinota", "Villa Capinota"};
    public static final String [] COC_07_CERCADO = {"Cercado", "Cochabamba"};
    public static final String [] COC_08_CARRASCO = {"Carrasco", "Totora"};
    public static final String [] COC_09_CHAPARE = {"Chapare", "Sacaba"};
    public static final String [] COC_10_GERMAN_JORDAN = {"Germán Jordán", "Villa Cliza"};
    public static final String [] COC_11_MIZQUE = {"Mizque", "Mizque"};
    public static final String [] COC_12_PUNATA = {"Punata", "Punata"};
    public static final String [] COC_13_QUILLACOLLO = {"Quillacollo", "Quillacollo"};
    public static final String [] COC_14_TAPACARI = {"Tapacarí", "Tapacarí"};
    public static final String [] COC_15_BOLIVAR = {"Bolívar", "Bolívar"};
    public static final String [] COC_16_TIRAQUE = {"Tiraque", "Tiraque"};
    // LA PAZ (20)
    public static final String [] LAP_01_AROMA = {"Aroma", "Sica Sica"};
    public static final String [] LAP_02_BAUTISTA_SAAVEDRA = {"Bautista Saavedra", "Charazani"};
    public static final String [] LAP_03_ABEL_ITURRALDE = {"Abel Iturralde", "Ixiamas"};
    public static final String [] LAP_04_CARANAVI = {"Caranavi", "Caranavi"};
    public static final String [] LAP_05_ELIODORO_CAMACHO = {"Eliodoro Camacho", "Puerto Acosta"};
    public static final String [] LAP_06_FRANZ_TAMAYO = {"Franz Tamayo", "Apolo"};
    public static final String [] LAP_07_GUALBERT_VILLAROEL = {"Gualberto Villaroel", "San Pedro de Curahuara de Carangas"};
    public static final String [] LAP_08_INGAVI = {"Ingavi", "Viacha"};
    public static final String [] LAP_09_INQUISIVI = {"Inquisivi", "Inquisivi"};
    public static final String [] LAP_10_JOSE_MANUEL_PANDO = {"José Manuel Pando", "Santiago de Machaca"};
    public static final String [] LAP_11_LARECAJA = {"Larecaja", "Sorata"};
    public static final String [] LAP_12_LOAYZA = {"Loayza", "Luribay"};
    public static final String [] LAP_13_LOS_ANDES = {"Los Andes", "Pucarani"};
    public static final String [] LAP_14_MANCO_KAPAC = {"Manco Kapac", "Copacabana"};
    public static final String [] LAP_15_MUNECAS = {"Muñecas", "Chuma"};
    public static final String [] LAP_16_NOR_YUNGAS = {"Nor Yungas", "Coroico"};
    public static final String [] LAP_17_OMASUYOS = {"Omasuyos", "Achacachi"};
    public static final String [] LAP_18_PACAJES = {"Pacajes", "Coro Coro"};
    public static final String [] LAP_19_PEDRO_DOMINGO_MURILLO = {"Pedro Domingo Murillo", "capital Palca"};
    public static final String [] LAP_20_SUD_YUNGAS = {"Sud Yungas", "Chulumani"};
    // ORURO (16)
    public static final String [] ORU_01_ATAHUALLPA = {"Atahuallpa", "Sabaya"};
    public static final String [] ORU_02_CARANGAS = {"Carangas", "Corque"};
    public static final String [] ORU_03_CERCADO = {"Cercado", "Oruro"};
    public static final String [] ORU_04_EDUARDO_AVAROA = {"Eduardo Avaroa", "Challapata"};
    public static final String [] ORU_05_LADISLAO_CABRERA = {"Ladislao Cabrera", "Salinas de Garcí Mendoza"};
    public static final String [] ORU_06_LITORAL = {"Litoral", "Huachacalla"};
    public static final String [] ORU_07_PUERTO_DE_MEJILLONES = {"Puerto de Mejillones", "La Rivera"};
    public static final String [] ORU_08_NOR_CARANGAS = {"Nor Carangas", "Huayllamarca"};
    public static final String [] ORU_09_PANTALEON_DALENCE = {"Pantaleón Dalence", "*"};
    public static final String [] ORU_10_POOPO = {"Poopó", "Poopó"};
    public static final String [] ORU_11_SAJAMA = {"Sajama", "Curahuara de Carangas"};
    public static final String [] ORU_12_SAN_PEDRO_DE_TOTORA = {"San Pedro de Totora", "Totora"};
    public static final String [] ORU_13_SAUCARI = {"Saucarí", "Toledo"};
    public static final String [] ORU_14_SEBASTIAN_PAGADOR = {"Sebastian Pagador", "Santiago de Huari"};
    public static final String [] ORU_15_SUD_CARANGAS = {"Sud Carangas", "Santiago de Andamarca"};
    public static final String [] ORU_16_TOMAS_BARRON = {"Tomas Barrón", "Eucaliptus"};
    // PANDO
    public static final String [] PAN_ABUNA = {"Abuná", "Santa Rosa de Abuná"};
    public static final String [] PAN_FEDERICO_ROMAN = {"Federico Román", "Fortaleza"};
    public static final String [] PAN_MADRE_DE_DIOS = {"Madre de Dios", "Puerto Gonzales Moreno"};
    public static final String [] PAN_MANURIPI = {"Manuripi", "Puerto Rico"};
    public static final String [] PAN_NICOLAS_SUAREZ = {"Nicolás Suárez", "Porvenir"};
    // POTOSÍ
    public static final String [] POT_01_ALONZO_DE_IBANEZ = {"Alonzo de Ibáñez", "Villa de Sacaca"};
    public static final String [] POT_02_ANTONIO_QUIJARRO = {"Antonio Quijarro", "Uyuni"};
    public static final String [] POT_03_BERNARDINO_BILBAO = {"Bernardino Bilbao", "Arampampa"};
    public static final String [] POT_04_CHARCAS = {"Charcas", "San Pedro de Buena Vista"};
    public static final String [] POT_05_CHAYANTA = {"Chayanta", "Colquechaca"};
    public static final String [] POT_06_CORNELIO_SAAVEDRA = {"Cornelio Saavedra", "Betanzos"};
    public static final String [] POT_07_DANIEL_SAAVEDRA = {"Daniel Saavedra", "Llica"};
    public static final String [] POT_08_ENRIQUE_BALDIVIESO = {"Enrique Baldivieso", "San Agustín"};
    public static final String [] POT_09_JOSE_MARIA_LINARES = {"José María Linares", "Puna"};
    public static final String [] POT_10_MODESTO_OMISTE = {"Modesto Omiste", "Villazón"};
    public static final String [] POT_11_NOR_CHICHAS = {"Nor Chichas", "Cotagaita"};
    public static final String [] POT_12_NOR_LIPEZ = {"Nor Lípez", "Colcha"};
    public static final String [] POT_13_RAFAEL_BUSTILLO = {"Rafael Bustillo", "Uncía"};
    public static final String [] POT_14_SUD_CHICHAS = {"Sud Chichas", "Tupiza"};
    public static final String [] POT_15_SUD_LIPEZ = {"Sud Lipez", "San Pablo de Lipez"};
    public static final String [] POT_16_TOMAS_FRIAS = {"Tomás Frías", "Tinguipaya"};
    // SANTA CRUZ
    public static final String [] SAN_01_ANDRES_IBANEZ = {"Andrés Ibáñez", "Ciudad de Santa Cruz"};
    public static final String [] SAN_02_IGNACIO_WARNES = {"Ignacio Warnes", "Warnes"};
    public static final String [] SAN_03_JOSE_MIGUEL_DE_VELASCO = {"José Miguel de Velasco", "San Ignacio"};
    public static final String [] SAN_04_ICHILO = {"Ichilo", "Buena Vista"};
    public static final String [] SAN_05_CHIQUITOS = {"Chiquitos", "San José"};
    public static final String [] SAN_06_SARA = {"Sara", "Portachuelo"};
    public static final String [] SAN_07_CORDILLERA = {"Cordillera", "Lagunillas"};
    public static final String [] SAN_08_VALLEGRANDE = {"Vallegrande", "Vallegrande"};
    public static final String [] SAN_09_FLORIDA = {"Florida", "Samaipata"};
    public static final String [] SAN_10_SANTISTEVAN = {"Santistevan", "Montero"};
    public static final String [] SAN_11_NUFLO_DE_CHAVEZ = {"Ñuflo de Chávez", "Concepción"};
    public static final String [] SAN_12_Ángel_Sandoval = {"Ángel Sandoval", "San Matías"};
    public static final String [] SAN_13_CABALLERO = {"Caballero", "Comarapa"};
    public static final String [] SAN_14_GERMAN_BUSCH = {"Germán Busch", "Puerto Suárez"};
    public static final String [] SAN_15_GUARAYOS = {"Guarayos", "Ascensión"};
    // TARIJA
    public static final String [] TAR_01_ANICETO_ARCE = {"Aniceto Arce", "Padcaya"};
    public static final String [] TAR_02_BURDET_O_CONNOR = {"Burdet O’Connor", "Entre Ríos"};
    public static final String [] TAR_03_CERCADO = {"Cercado", "Tarija"};
    public static final String [] TAR_04_EUSTAQUIO_MENDEZ = {"Eustaquio Méndez", "San Lorenzo"};
    public static final String [] TAR_05_GRAN_CHACO = {"Gran Chaco", "Yacuíba"};
    public static final String [] TAR_06_JOSE_MARIA_AVILES = {"José María Avilés", "Uriondo"};
    */
}
