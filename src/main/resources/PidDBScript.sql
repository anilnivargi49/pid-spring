CREATE TABLE master_list(
id SERIAL PRIMARY KEY,
pid_ref INTEGER NOT NULL,
service_area_id INTEGER NOT NULL,
device_id INTEGER NOT NULL,
device_function_id INTEGER,
measurement_id INTEGER,
isa_code INTEGER,
loop_no INTEGER,
no_of_wires INTEGER,
device_tag VARCHAR(20),
junction_box_id VARCHAR(20),
cable_tag VARCHAR(20),
marshell_rack_id INTEGER,
marshell_rack_term VARCHAR(25),
plc_panel_id VARCHAR(20),
plc_id VARCHAR(10),
plc_panel_term_blk VARCHAR(30),
plc_panel_term_no INTEGER,
slot_no INTEGER,
channel_no INTEGER,
io_type VARCHAR(20),
io_tag VARCHAR(30),
FOREIGN KEY(pid_ref) REFERENCES pid_reference(id),
FOREIGN KEY(service_area_id) REFERENCES service_area_codes(id),
FOREIGN KEY(device_id) REFERENCES pid_reference(id),
FOREIGN KEY(device_function_id) REFERENCES device_function(id),
FOREIGN KEY(measurement_id) REFERENCES measurements(id),
);

CREATE TABLE pid_reference(
id SERIAL PRIMARY KEY,
pid_ref VARCHAR(20) NOT NULL,
active BOOLEAN DEFAULT TRUE
);

CREATE TABLE pid_devices(
id SERIAL PRIMARY KEY,
device_name VARCHAR(30) NOT NULL,
active BOOLEAN DEFAULT TRUE
);
CREATE TABLE device_function(
id SERIAL PRIMARY KEY,
device_id INTEGER NOT NULL,
device_function VARCHAR(30) NOT NULL,
FOREIGN KEY(device_id) REFERENCES pid_devices(id)
);

CREATE TABLE measurements(
id SERIAL PRIMARY KEY,
device_function_id INTEGER NOT NULL,
measurement VARCHAR(40) NOT NULL,
FOREIGN KEY(device_function_id) REFERENCES device_function(id)
);

CREATE TABLE isa_codes(
id SERIAL PRIMARY KEY,
measurement_id INTEGER NOT NULL,
isa_code VARCHAR(10),
FOREIGN KEY(measurement_id) REFERENCES measurements(id)
);

CREATE TABLE service_area_codes(
id SERIAL PRIMARY KEY,
service_area VARCHAR(80) NOT NULL,
area_code INTEGER NOT NULL
);

CREATE TABLE device_templates(
id SERIAL PRIMARY KEY,
device_id INTEGER NOT NULL,
device_template text,
active boolean DEFAULT TRUE,
FOREIGN KEY(device_id) REFERENCES pid_devices(id)
);

--master data for pid references
INSERT INTO pid_reference VALUES(1, 'TBG/AG/150_CSI/R0', true);
INSERT INTO pid_reference VALUES(2, 'TBG/AG/150_CSI/R1', true);
INSERT INTO pid_reference VALUES(3, 'TBG/AG/150_CSI/R2', true);
INSERT INTO pid_reference VALUES(4, 'TBG/AG/150_CSI/R3', true);

--master data for service area
INSERT INTO service_area_codes VALUES(1, 113,'CBD/IBD Tank level control');
INSERT INTO service_area_codes VALUES(2, 107,'De-Aerator Lvl Ctrl');
INSERT INTO service_area_codes VALUES(3,124, 'De-Aerator Mon & Alm');
INSERT INTO service_area_codes VALUES(4,108,'De-Aerator Pres Ctrl');
INSERT INTO service_area_codes VALUES(5,119,'DM Water System');
INSERT INTO service_area_codes VALUES(6,101,'Drum level Control');
INSERT INTO service_area_codes VALUES(7,123,'Drum Mon & Alm');
INSERT INTO service_area_codes VALUES(8,160,'FD Air');
INSERT INTO service_area_codes VALUES(9,109,'FD FanAi FlowCtrl');
INSERT INTO service_area_codes VALUES(10,102,'Feed Water');
INSERT INTO service_area_codes VALUES(11,170,'Flue Gas');
INSERT INTO service_area_codes VALUES(12,112,'FuelBagasseFeedCtrl');
INSERT INTO service_area_codes VALUES(13,106,'Furnace Pres. Ctrl.');
INSERT INTO service_area_codes VALUES(14,140,'FW DeAerator');
INSERT INTO service_area_codes VALUES(15,127,'FW Tank');
INSERT INTO service_area_codes VALUES(16,128,'HP  dosing');
INSERT INTO service_area_codes VALUES(17,118,'HP heater Level Control');
INSERT INTO service_area_codes VALUES(18,120,'HP Process (TG Extraction)');
INSERT INTO service_area_codes VALUES(19,130,'Instrument Air Compresor');
INSERT INTO service_area_codes VALUES(20,129,'LP Dosing');
INSERT INTO service_area_codes VALUES(21,122,'LP Process (TG Extraction)');
INSERT INTO service_area_codes VALUES(22,132,'Misc / Other');
INSERT INTO service_area_codes VALUES(23,121,'MP Process (TG Extraction)');
INSERT INTO service_area_codes VALUES(24,180,'Oil System');
INSERT INTO service_area_codes VALUES(25,114,'PRDS 1');
INSERT INTO service_area_codes VALUES(26,115,'PRDS 2');
INSERT INTO service_area_codes VALUES(27,116,'PRDS 3');
INSERT INTO service_area_codes VALUES(28,117,'PRDS 4');
INSERT INTO service_area_codes VALUES(29,125,'Pumps Mon & Alm');
INSERT INTO service_area_codes VALUES(30,110,'SA FanAi FlowCtrl');
INSERT INTO service_area_codes VALUES(31,105,'SH Steam Pressure');
INSERT INTO service_area_codes VALUES(32,104,'SH steam temp Control');
INSERT INTO service_area_codes VALUES(33,126,'Soot Blower Mon & Alm');
INSERT INTO service_area_codes VALUES(34,111,'St BlwStmPresCtrl');
INSERT INTO service_area_codes VALUES(35,150,'Steam');
INSERT INTO service_area_codes VALUES(36,103,'Superheated Steam Flow');
INSERT INTO service_area_codes VALUES(37,131,'Turbine - Gen.');

--master data for pid devices
INSERT INTO pid_devices VALUES(1, TRUE,'Alarms_Switches');
INSERT INTO pid_devices VALUES(2, TRUE,'Solenoids');
INSERT INTO pid_devices VALUES(3, TRUE,'Control_Valves');
INSERT INTO pid_devices VALUES(4, TRUE,'Controllers');
INSERT INTO pid_devices VALUES(5, TRUE,'Elements');
INSERT INTO pid_devices VALUES(6, TRUE,'Read_Outs');
INSERT INTO pid_devices VALUES(7, TRUE,'Test_Points');
INSERT INTO pid_devices VALUES(8, TRUE,'Transmitters');
INSERT INTO pid_devices VALUES(9, TRUE,'Well_Probes');
INSERT INTO pid_devices VALUES(10, TRUE,'Controls');

--master data for device function
INSERT INTO device_function VALUES(1,'AlSw_Hi', 1);
INSERT INTO device_function VALUES(2,'AlSw_HiLo', 1);
INSERT INTO device_function VALUES(3,'AlSw_Lo', 1);
INSERT INTO device_function VALUES(4,'Comp_Devices', 2);
INSERT INTO device_function VALUES(5,'Sol_Relays', 2);
INSERT INTO device_function VALUES(6,'Blind', 3);
INSERT INTO device_function VALUES(7,'Indicator', 3);
INSERT INTO device_function VALUES(8,'Recorder', 3);
INSERT INTO device_function VALUES(9,'Primary', 4);
INSERT INTO device_function VALUES(10,'Final', 4);
INSERT INTO device_function VALUES(11,'RO_Indicator', 5);
INSERT INTO device_function VALUES(12,'RO_Recorder', 5);
INSERT INTO device_function VALUES(13,'Switches_Hi', 6); 
INSERT INTO device_function VALUES(14,'Switches_HiLo', 6);
INSERT INTO device_function VALUES(15,'Switches_Lo', 6);
INSERT INTO device_function VALUES(16,'Blind', 7);
INSERT INTO device_function VALUES(17,'Indicator', 7);
INSERT INTO device_function VALUES(18,'Recorder', 7);
INSERT INTO device_function VALUES(19,'Viewing_Device', 8);
INSERT INTO device_function VALUES(20,'Mechanical', 9);
INSERT INTO device_function VALUES(21,'Electrical', 9);
INSERT INTO device_function VALUES(22,'Pneumatic', 9);
INSERT INTO device_function VALUES(23,'Hydraulic', 9);
INSERT INTO device_function VALUES(24,'ACDrives', 10);
INSERT INTO device_function VALUES(25,'DCDrives', 10);
INSERT INTO device_function VALUES(26,'Starters', 10);
INSERT INTO device_function VALUES(27,'SoftStarters', 10);

--master data for measurements
INSERT INTO measurements VALUES(1,'Analyser',1);
INSERT INTO measurements VALUES(2,'Burner',1);
INSERT INTO measurements VALUES(3,'Current',1);
INSERT INTO measurements VALUES(4,'Event',1);
INSERT INTO measurements VALUES(5,'Flow_qty',1);
INSERT INTO measurements VALUES(6,'Flow_Rate',1);
INSERT INTO measurements VALUES(7,'Flow_ratio',1);
INSERT INTO measurements VALUES(8,'Gaging/Devn',1);
INSERT INTO measurements VALUES(9,'Level',1);
INSERT INTO measurements VALUES(10,'Posn/Dimn',1);
INSERT INTO measurements VALUES(11,'Power',1);
INSERT INTO measurements VALUES(12,'Pressure',1);
INSERT INTO measurements VALUES(13,'Pr_Diffl',1);
INSERT INTO measurements VALUES(14,'Quantity',1);
INSERT INTO measurements VALUES(15,'Radiation',1);
INSERT INTO measurements VALUES(16,'Speed_Freq',1);
INSERT INTO measurements VALUES(17,'Temperature',1);
INSERT INTO measurements VALUES(18,'Temp_Diffl',1);
INSERT INTO measurements VALUES(19,'Time',1);
INSERT INTO measurements VALUES(20,'Vibration',1);
INSERT INTO measurements VALUES(21,'Voltage',1);
INSERT INTO measurements VALUES(22,'Wt/Force',1);
INSERT INTO measurements VALUES(23,'Wt/Frc_Diffl',1);
INSERT INTO measurements VALUES(24,'Analyser',2);
INSERT INTO measurements VALUES(25,'Burner',2);
INSERT INTO measurements VALUES(26,'Current',2);
INSERT INTO measurements VALUES(27,'Flow_Rate',2);
INSERT INTO measurements VALUES(28,'Level',2);
INSERT INTO measurements VALUES(29,'Posn/Dimn',2);
INSERT INTO measurements VALUES(30,'Power',2);
INSERT INTO measurements VALUES(31,'Pressure',2);
INSERT INTO measurements VALUES(32,'Quantity',2);
INSERT INTO measurements VALUES(33,'Radiation',2);
INSERT INTO measurements VALUES(34,'Speed_Freq',2);
INSERT INTO measurements VALUES(35,'Temperature',2);
INSERT INTO measurements VALUES(36,'Time',2);
INSERT INTO measurements VALUES(37,'Vibration',2);
INSERT INTO measurements VALUES(38,'Voltage',2);
INSERT INTO measurements VALUES(39,'Wt/Force',2);
INSERT INTO measurements VALUES(40,'Analyser',3);
INSERT INTO measurements VALUES(41,'Burner',3);
INSERT INTO measurements VALUES(42,'Current',3);
INSERT INTO measurements VALUES(43,'Event',3);
INSERT INTO measurements VALUES(44,'Flow_Qty',3);
INSERT INTO measurements VALUES(45,'Flow_Rate',3);
INSERT INTO measurements VALUES(46,'Flow_ratio',3);
INSERT INTO measurements VALUES(47,'Gauging/Devn',3);
INSERT INTO measurements VALUES(48,'Level',3);
INSERT INTO measurements VALUES(49,'Posn/Dimn',3);
INSERT INTO measurements VALUES(50,'Power',3);
INSERT INTO measurements VALUES(51,'Pressure',3);
INSERT INTO measurements VALUES(52,'Pr_Diffl',3);
INSERT INTO measurements VALUES(53,'Quantity',3);
INSERT INTO measurements VALUES(54,'Radiation',3);
INSERT INTO measurements VALUES(55,'Speed_Freq',3);
INSERT INTO measurements VALUES(56,'Temperature',3);
INSERT INTO measurements VALUES(57,'Temp_Diffl',3);
INSERT INTO measurements VALUES(58,'Time',3);
INSERT INTO measurements VALUES(59,'Vibration',3);
INSERT INTO measurements VALUES(60,'Voltage',3);
INSERT INTO measurements VALUES(61,'Wt/Force',3);
INSERT INTO measurements VALUES(62,'Wt/Frc_Diffl',3);


CREATE SEQUENCE master_list-seq START WITH 2;
ALTER TABLE master_list ALTER COLUMN id SET DEFAULT nextval('master_list-seq');
ALTER TABLE master_list ALTER COLUMN isa_code TYPE VARCHAR(10);
