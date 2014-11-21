--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2014-11-13 14:23:53 PYST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 226 (class 1259 OID 30864)
-- Dependencies: 6
-- Name: datos_dataset; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE datos_dataset (
    id integer NOT NULL,
    numero character varying,
    nombre character varying,
    descripcion character varying,
    servicio character varying,
    link character varying
);


ALTER TABLE public.datos_dataset OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 30870)
-- Dependencies: 6
-- Name: datos_dataset_dic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE datos_dataset_dic (
    id integer NOT NULL,
    id_dataset integer NOT NULL,
    id_diccionario integer NOT NULL
);


ALTER TABLE public.datos_dataset_dic OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 30873)
-- Dependencies: 6 227
-- Name: datos_dataset_dic_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE datos_dataset_dic_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.datos_dataset_dic_id_seq OWNER TO postgres;

--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 228
-- Name: datos_dataset_dic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE datos_dataset_dic_id_seq OWNED BY datos_dataset_dic.id;


--
-- TOC entry 229 (class 1259 OID 30875)
-- Dependencies: 226 6
-- Name: datos_dataset_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE datos_dataset_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.datos_dataset_id_seq OWNER TO postgres;

--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 229
-- Name: datos_dataset_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE datos_dataset_id_seq OWNED BY datos_dataset.id;


--
-- TOC entry 230 (class 1259 OID 30877)
-- Dependencies: 6
-- Name: datos_diccionario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE datos_diccionario (
    id integer NOT NULL,
    atributo character varying,
    descripcion character varying,
    tipo_dato character varying,
    restricciones character varying,
    referencia character varying,
    ejemplo character varying
);


ALTER TABLE public.datos_diccionario OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 30883)
-- Dependencies: 230 6
-- Name: datos_diccionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE datos_diccionario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.datos_diccionario_id_seq OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 231
-- Name: datos_diccionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE datos_diccionario_id_seq OWNED BY datos_diccionario.id;


--
-- TOC entry 232 (class 1259 OID 30885)
-- Dependencies: 6
-- Name: datos_visualizacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE datos_visualizacion (
    id integer NOT NULL,
    numero character varying,
    nombre character varying,
    descripcion character varying,
    vista_previa character varying,
    link character varying
);


ALTER TABLE public.datos_visualizacion OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 30891)
-- Dependencies: 232 6
-- Name: datos_visualizacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE datos_visualizacion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.datos_visualizacion_id_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 233
-- Name: datos_visualizacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE datos_visualizacion_id_seq OWNED BY datos_visualizacion.id;


--
-- TOC entry 2824 (class 2604 OID 30893)
-- Dependencies: 229 226
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_dataset ALTER COLUMN id SET DEFAULT nextval('datos_dataset_id_seq'::regclass);


--
-- TOC entry 2825 (class 2604 OID 30894)
-- Dependencies: 228 227
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_dataset_dic ALTER COLUMN id SET DEFAULT nextval('datos_dataset_dic_id_seq'::regclass);


--
-- TOC entry 2826 (class 2604 OID 30895)
-- Dependencies: 231 230
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_diccionario ALTER COLUMN id SET DEFAULT nextval('datos_diccionario_id_seq'::regclass);


--
-- TOC entry 2827 (class 2604 OID 30896)
-- Dependencies: 233 232
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_visualizacion ALTER COLUMN id SET DEFAULT nextval('datos_visualizacion_id_seq'::regclass);


--
-- TOC entry 2939 (class 0 OID 30864)
-- Dependencies: 226 2947
-- Data for Name: datos_dataset; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (1, '1', 'Ranking de Exportadores', 'Contiene informacion sobre el top 10 de las empresas exportadoras del Paraguay, ordenados por el total del valor FOB de lo exportado', 'ranking/exportacion', 'rankingExportaciones');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (2, '2', 'Ranking de Importadores', 'Contiene informacion sobre el top 10 de las empresas importadoras por el Paraguay, ordenados por el total del valor FOB de lo importado', 'ranking/importacion', 'rankingImportaciones');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (3, '3', 'Ranking de Productos Importados', 'Contiene informacion sobre el top 10 de los productos importados por el Paraguay, ordenados por el total del valor FOB de lo importado', 'ranking/producto/importados', 'rankingProductosImportados');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (4, '4', 'Exportaciones por Año', 'Contiene informacion sobre todas las exportaciones realizadas en el año seleccionado', 'exportacionesPorAnho', 'exportacionesPorAnho');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (5, '5', 'Importaciones por Año', 'Contiene informacion sobre todas las importaciones realizadas en el año seleccionado', 'importacionesPorAnho', 'importacionesPorAnho');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (6, '6', 'Exportaciones por Categoria', 'Contiene informacion sobre todas las exportaciones realizadas agrupados por la categoria dentro del periodo seleccionado', 'exportacionesPorCategoria', 'exportacionesPorCategoria');
INSERT INTO datos_dataset (id, numero, nombre, descripcion, servicio, link) VALUES (7, '7', 'Exportaciones por País', 'Contiene informacion sobre todas las exportaciones realizadas agrupadas por país dentro del periodo de busqueda', 'exportacionesPorPais', 'exportacionesPorPais');


--
-- TOC entry 2940 (class 0 OID 30870)
-- Dependencies: 227 2947
-- Data for Name: datos_dataset_dic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (1, 1, 2);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (2, 1, 3);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (3, 1, 4);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (4, 1, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (5, 1, 6);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (6, 7, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (7, 7, 6);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (8, 7, 7);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (9, 2, 2);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (10, 5, 15);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (11, 2, 3);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (12, 2, 4);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (13, 2, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (14, 2, 6);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (15, 3, 2);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (16, 3, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (17, 3, 8);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (18, 3, 9);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (19, 6, 2);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (20, 6, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (21, 6, 6);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (22, 6, 8);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (23, 6, 9);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (24, 6, 10);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (25, 4, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (26, 4, 11);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (27, 4, 12);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (30, 4, 13);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (31, 4, 14);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (32, 4, 15);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (33, 5, 5);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (34, 5, 11);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (35, 5, 12);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (36, 5, 13);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (37, 5, 14);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (38, 4, 16);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (39, 5, 16);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (40, 4, 17);
INSERT INTO datos_dataset_dic (id, id_dataset, id_diccionario) VALUES (41, 5, 17);




--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 228
-- Name: datos_dataset_dic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('datos_dataset_dic_id_seq', 41, true);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 229
-- Name: datos_dataset_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('datos_dataset_id_seq', 7, true);


--
-- TOC entry 2943 (class 0 OID 30877)
-- Dependencies: 230 2947
-- Data for Name: datos_diccionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (1, 'Establece el nombre del atributo exactamente como se encuentra definido en el archivo de datos a ser publicado', 'Describe con más detalles los datos que se encuentran en el atributo', 'El tipo de dato esperado de los valores del attributo. Por ejemplo: String, Integer, Float, …. Idealmente se deben utilizar los tipos de datos definidos en el Estándar XML Schema Datatypes de la W3C. http://www.w3.org/TR/xmlschema-2/#built-in-primitive-datatypes, por ejemplo: xsd:string, xsd:boolean, xsd:dateTime ', 'En caso que existan, se especifican las restricciones de los datos ', 'En caso que exista, se agrega un link a un documento de referencia para los datos. Por ejemplo, si los datos están definidos utilizando un estándar o formato diferente a XSD, se lo referencia, como ser la Latitud y Longitud en formato de Google maps ', 'Los valores de ejemplo ');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (2, 'anhomes', 'Se refiere al Año concatenado con el Mes del ranking segun la fecha de exportacion', 'xsd:string', 'Valor no puede ser menor a la carga de los datos, y debe tener 6 caracteres exactamente', NULL, '201310');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (3, 'ruc', 'Se refiere al Ruc de la Empresa exportadora', 'xsd:string', 'Debe tener el digito verificador concatenado y no debe ser mayor a 10 caracteres', NULL, '800011113');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (6, 'kilo_neto', 'Se refiere a la cantidad en Kilos de los productos exportados', 'xsd:positiveInteger ', 'No debe ser menor que 0', NULL, '5000');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (4, 'razon_social', 'Se refiere al Nombre de la Empresa exportadora', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'EMPRESA DE EJEMPLO S.A.');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (5, 'valor_fob_dolar', 'Se refiere al valor de lo exportado/importado sin tener en cuenta los gastos por Flete expresado en Dolares Estadounidenses', 'xsd:positiveInteger ', 'No debe ser menor que 0', NULL, '1425423');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (8, 'categoria', 'Se refiere a la Categoria de producto que se esta exportando ', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'Metal-Mecanica');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (9, 'subcategoria', 'Se refiere a la Sub Categoria que depende de la Categoria del producto que se esta exportando', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'Chapas, varillas, perfiles etc. de hierro y acero');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (10, 'partida', 'Se refiere al codigo nomenclador comun del mercosur que hace referencia al producto que se exporta', 'xsd:string', 'No debe ser mayor que 255 caracteres', 'www.aduanaargentina.com/nc.php', '72.07');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (11, 'comprador', 'Se refiere al nombre de la Empresa que esta realizando la Importacion/Exportacion', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'EMPRESA DE EJEMPLO S.A.');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (7, 'pais_abreviado', 'Se refiere al nombre del pais que esta recibiendo la exportacion', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'ITALIA');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (14, 'pais_destino', 'Se refiere al nombre del pais de destino en la transaccion', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'ITALIA');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (15, 'pais_origen', 'Se refiere al nombre del pais de origen en la transaccion', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'PARAGUAY');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (13, 'exportador', 'Se refiere al codigo abreviado del pais exportador en la transaccion', 'xsd:string', 'No debe ser mayor que 255 caracteres', 'http://www.europarl.europa.eu/transl_es/plataforma/pagina/maletin/colecc/glosario/pe/paises.htm', 'PY');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (12, 'importador', 'Se refiere al codigo abreviado del pais importador en la transaccion', 'xsd:string', 'No debe ser mayor que 255 caracteres', 'http://www.europarl.europa.eu/transl_es/plataforma/pagina/maletin/colecc/glosario/pe/paises.htm', 'IT');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (16, 'año', 'Se refiere al año de la transaccion', 'xsd:positiveInteger', 'Debe ser mayor a 0', NULL, '2014');
INSERT INTO datos_diccionario (id, atributo, descripcion, tipo_dato, restricciones, referencia, ejemplo) VALUES (17, 'mes_nombre', 'Se refiere al nombre del mes de la transaccion', 'xsd:string', 'No debe ser mayor que 255 caracteres', NULL, 'Enero');


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 231
-- Name: datos_diccionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('datos_diccionario_id_seq', 17, true);


--
-- TOC entry 2945 (class 0 OID 30885)
-- Dependencies: 232 2947
-- Data for Name: datos_visualizacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO datos_visualizacion (id, numero, nombre, descripcion, vista_previa, link) VALUES (1, '1', 'Mapas de Exportación e Importación', 'Gráfico del mapa mundial con sombreados y flechas sobre los orígenes, destinos y montos de las exportaciones e importaciones ', '/images/mapa_imp_exp.png', 'mapa_imp_exp.jsf');
INSERT INTO datos_visualizacion (id, numero, nombre, descripcion, vista_previa, link) VALUES (2, '2', 'Ranking de Exportación', 'Gráfico de Torta sobre el top 10 de las Empresas Exportadoras', '/images/ranking_exp.png', 'chart_export.jsf');
INSERT INTO datos_visualizacion (id, numero, nombre, descripcion, vista_previa, link) VALUES (3, '3', 'Ranking de Importaciones', 'Gráfico de Torta sobre el top 10 de las Empresas Importadoras', '/images/ranking_imp.png', 'chart_import.jsf');
INSERT INTO datos_visualizacion (id, numero, nombre, descripcion, vista_previa, link) VALUES (4, '4', 'TreeMap de Exportación por País', 'Gráfico de treemap que muestra con verde el mejor pais y el resto tiende a azul segun la posición que obtenga, según el Valor FOB de lo Exportado', '/images/treemap_exp.png', 'treemap_exp.jsf');
INSERT INTO datos_visualizacion (id, numero, nombre, descripcion, vista_previa, link) VALUES (5, '5', 'Ranking de Productos Importados', 'Gráfico de Torta sobre el top 10 de los Productos Importados', '/images/ranking_prod.png', 'chart_productos.jsf');

--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 233
-- Name: datos_visualizacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('datos_visualizacion_id_seq', 5, true);


--
-- TOC entry 2829 (class 2606 OID 30898)
-- Dependencies: 226 226 2948
-- Name: pk_dataset; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY datos_dataset
    ADD CONSTRAINT pk_dataset PRIMARY KEY (id);


--
-- TOC entry 2831 (class 2606 OID 30900)
-- Dependencies: 227 227 2948
-- Name: pk_dataset_dic; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY datos_dataset_dic
    ADD CONSTRAINT pk_dataset_dic PRIMARY KEY (id);


--
-- TOC entry 2833 (class 2606 OID 30902)
-- Dependencies: 230 230 2948
-- Name: pk_diccionario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY datos_diccionario
    ADD CONSTRAINT pk_diccionario PRIMARY KEY (id);


--
-- TOC entry 2835 (class 2606 OID 30904)
-- Dependencies: 232 232 2948
-- Name: pk_visualizacion; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY datos_visualizacion
    ADD CONSTRAINT pk_visualizacion PRIMARY KEY (id);


--
-- TOC entry 2836 (class 2606 OID 30905)
-- Dependencies: 226 2828 227 2948
-- Name: fk_dataset; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_dataset_dic
    ADD CONSTRAINT fk_dataset FOREIGN KEY (id_dataset) REFERENCES datos_dataset(id);


--
-- TOC entry 2837 (class 2606 OID 30910)
-- Dependencies: 227 230 2832 2948
-- Name: fk_diccionario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY datos_dataset_dic
    ADD CONSTRAINT fk_diccionario FOREIGN KEY (id_diccionario) REFERENCES datos_diccionario(id);


-- Completed on 2014-11-13 14:23:53 PYST

--
-- PostgreSQL database dump complete
--
