--INSERT INTO faltas (id_alumno, fecha, materia, justificada, motivo_justificacion) 
--VALUES (1, '2026-10-15', 'Acceso a Datos', false, NULL);
--
--INSERT INTO faltas (id_alumno, fecha, materia, justificada, motivo_justificacion) 
--VALUES (1, '2026-10-18', 'Desarrollo Interfaces', false, NULL);
--
--INSERT INTO faltas (id_alumno, fecha, materia, justificada, motivo_justificacion) 
--VALUES (1, '2026-10-10', 'Sistemas de Gestión', true, 'Cita médica en el centro de salud');
--
--INSERT INTO faltas (id_alumno, fecha, materia, justificada, motivo_justificacion) 
--VALUES (2, '2026-10-19', 'Acceso a Datos', false, NULL);

-- 1. Departamentos
INSERT INTO departamentos (codigo_departamento, nombre_departamento) VALUES 
('INF', 'Informática y Comunicaciones'),
('MAT', 'Matemáticas y Estadística');

-- 2. Profesores
INSERT INTO profesores (dni, nombre, codigo_departamento) VALUES 
('11111111A', 'Regino Fernández', 'INF'),
('22222222B', 'María López', 'MAT');

-- 3. Asignaturas
INSERT INTO asignaturas (codigo_asignatura, nombre, dni_profesor) VALUES 
('ISO', 'Implantación de Sistemas Operativos', '11111111A'),
('ADD', 'Acceso a Datos', '11111111A'),
('EST', 'Estadística Aplicada', '22222222B');

-- 4. Estudiantes
INSERT INTO estudiantes (dni, nombre) VALUES 
('33333333C', 'Carlos García'),
('44444444D', 'Ana Martínez');

-- 5. Matriculaciones
INSERT INTO matriculaciones (dni_estudiante, codigo_asignatura, fecha_matriculacion, nota_final) VALUES 
('33333333C', 'ADD', '2026-09-15', 8.5),
('33333333C', 'ISO', '2026-09-15', 7.0),
('44444444D', 'EST', '2026-09-16', 9.2);