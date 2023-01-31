import React, {useEffect, useState} from "react";
import axios from 'axios';
import Swal from 'sweetalert2';
import withReactContent from "sweetalert2-react-content";
import {show_alert} from './Functions';
import { endPoint } from './Config';

const resource = '/client'

const Instructores = () => {
    let url = endPoint + resource;
    const [clients, setClients] = useState([]);
    const [id, setId] = useState('');
    const [dni, setDni] = useState('');
    const [name, setName] = useState('');
    const [lastname, setLastName] = useState('');
    const [gender, setGender] = useState('');
    const [birthdate, setBirthdate] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [cellPhoneNumber, setCellPhoneNumber] = useState('');
    const [especializacion, setEspecializacion] = useState('');
    const [operation, setOperation] = useState('');
    const [title, setTitle] = useState('');

    const getEspecializaciones = async () => {
        const respuesta = await axios.get(endPoint + "/specialization").then(respuesta => {
            for(let i of respuesta.data){
               options.push({value: i.id, text: i.name})
            }
            console.log(options);
        });
    }

    const options = [];

    const handleChange = event => {
        setGender(event.target.value);
    };

    useEffect(() => {
        getClients().then(() => null)
    }, []);

    const getClients = async () => {
        await getEspecializaciones();
        const respuesta = await axios.get(url).then(respuesta => {
            setClients(respuesta.data);
        });
    }

    const openModal = (op, id, dni, name, lastname, gender, birthdate, password, email, cellPhoneNumber) => {
        setId('');
        setDni('');
        setName('');
        setLastName('');
        setGender('');
        setBirthdate('');
        setPassword('');
        setEmail('');
        setCellPhoneNumber('');
        setOperation(op);
        if (op === 1) {
            setTitle('Registrar Cliente');
        } else if (op === 2) {
            setTitle('Editar Cliente');
            setId(id);
            setDni(dni);
            setName(name);
            setLastName(lastname);
            setGender(gender);
            setBirthdate(birthdate);
            setPassword(password);
            setEmail(email);
            setCellPhoneNumber(cellPhoneNumber);
        }
        window.setTimeout(function () {
            document.getElementById('nombre').focus();
        }, 500);
    }
    const validar = () => {
        let parametros;
        let metodo;
        if (name.trim() === '') {
            show_alert('Escriba un nombre', 'warning');
        } else if (lastname.trim() === '') {
            show_alert('Escriba un nombre', 'warning');
        } else if (birthdate.trim() === '') {
            show_alert('Escriba un nombre', 'warning');
        } else if (email.trim() === '') {
            show_alert('Escriba un nombre', 'warning');
        } else {
            if (operation === 1) {
                parametros = {
                    id: id,
                    dni: dni,
                    name: name.trim(),
                    lastname: lastname.trim(),
                    gender: gender.trim(),
                    birthdate: birthdate.trim(),
                    password: password.trim(),
                    email: email,
                    cellPhoneNumber: cellPhoneNumber
                };
                metodo = 'post';
                url = endPoint + resource

            } else {
                parametros = {
                    id: id,
                    dni: dni,
                    name: name.trim(),
                    lastname: lastname.trim(),
                    gender: gender.trim(),
                    birthdate: birthdate.trim(),
                    password: password.trim(),
                    email: email,
                    cellPhoneNumber: cellPhoneNumber
                };
                metodo = 'put';
                url = endPoint + resource + "/" + id.toString()
            }
            enviarSolicitud(metodo, parametros).then(() => null);
        }
    }

    const enviarSolicitud = async (metodo, parametros) => {
        await axios({ method:metodo, url:url, data:parametros}).then(function(respuesta){
            if (respuesta.status === 200){
                show_alert("Cambios Guardados", 'success');
                document.getElementById('btnCerrar').click();
            }
        })
        .catch(function(error){
            show_alert('Error en la solicitud','error');
        });
    }

    const deleteClient=(id,name) => {
        const MySwal = withReactContent(Swal);
        MySwal.fire({
            title:'¿Seguro desea eliminar ' +name+ ' ?',
            icon: 'question',text:'No hay marcha atrás',
            showCancelButton:true,confirmButtonText:'Si, eliminar', cancelButtonText:'Cancelar'

        }).then((result)=>{
            if(result.isConfirmed){
                setId(id);
                url = endPoint + resource + "/" + id.toString()
                enviarSolicitud('delete',{id:id});
            }
            else{
                show_alert('El cliente NO fue eliminado','info')
            }
        });
    }

    return (
        <div className="App">
            <div className='container-fluid'>
                <div className='row mt-3'>
                    <div className='col-md-4 offset-md-4'>
                        <div className='d-grid mx-auto'>
                            <button onClick={() => openModal(1)} className='btn btn-dark' data-bs-toggle='modal'
                                    data-bs-target='#modalClients'>
                                <i className='fa-solid fa-circle-plus'></i> Añadir
                            </button>
                        </div>
                    </div>
                </div>
                <div className='row mt-3'>
                    <div className='col-12 col-lg-8 offset-0 offset-lg-2'>
                        <div className="table-responsive m-0">
                            <table className='table table-bordered'>
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>DNI</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Genero</th>
                                    <th>Fecha nacimiento</th>
                                    <th>Contraseña</th>
                                    <th>Email</th>
                                    <th>Celular</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody className="table-group-divider">
                                {clients.map((client, i) => (
                                    <tr key={client.id}>
                                        <td>{client.id}</td>
                                        <td>{client.dni}</td>
                                        <td>{client.name}</td>
                                        <td>{client.lastname}</td>
                                        <td>{client.gender}</td>
                                        <td>{client.birthdate}</td>
                                        <td>{ "********" }</td>
                                        <td>{client.email}</td>
                                        <td>{client.cellPhoneNumber}</td>
                                        <td>
                                            <button
                                                onClick={() => openModal(2, client.id, client.dni, client.name, client.lastname, client.gender, client.birthdate, client.password, client.email, client.cellPhoneNumber)}
                                                className='btn btn-warning' data-bs-toggle='modal'
                                                data-bs-target='#modalClients'>
                                                <i className="fa-solid fa-edit"></i>
                                            </button>
                                            &nbsp;
                                            <button onClick={()=>deleteClient(client.id,client.name)} className="btn btn-danger">
                                                <i className="fa-solid fa-trash"></i>
                                            </button>
                                        </td>
                                    </tr>
                                ))
                                }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div id='modalClients' className='modal fade' aria-hidden='true'>
                <div className='modal-dialog'>
                    <div className='modal-content'>
                        <div className='modal-header'>
                            <label className='h5'>{title}</label>
                            <button type='button' className='btn-close' data-bs-dismiss='modal'
                                    arial-label='Close'></button>
                        </div>
                        <div className='modal-body'>
                            <input type='hidden' id='id'></input>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-address-card'></i></span>
                                <input type='number' id='cedula' className='form-control' placeholder='Dni' value={dni}
                                       onChange={(e) => setDni(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-person'></i></span>
                                <input type='text' id='nombre' className='form-control' placeholder='Nombre'
                                       value={name}
                                       onChange={(e) => setName(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-person'></i></span>
                                <input type='text' id='apellido' className='form-control' placeholder='Apellido'
                                       value={lastname}
                                       onChange={(e) => setLastName(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-person'></i></span>
                                <select value={gender} onChange={handleChange}>
                                    {options.map(options => (
                                        <option key={options.value} value={options.value}>
                                            {options.text}
                                        </option>
                                    ))}
                                </select>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-birthday-cake'></i></span>
                                <input type='date' id='cumpleaños' className='form-control' placeholder='Cumpleaños'
                                       value={birthdate}
                                       onChange={(e) => setBirthdate(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-comment-dots'></i></span>
                                <input type='text' id='contraseña' className='form-control' placeholder='Contraseña'
                                       value={password}
                                       onChange={(e) => setPassword(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-mail-bulk'></i></span>
                                <input type='email' id='correo' className='form-control' placeholder='E-mail'
                                       value={email}
                                       onChange={(e) => setEmail(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-phone-alt'></i></span>
                                <input type='number' id='telefono' className='form-control' placeholder='Celular'
                                       value={cellPhoneNumber}
                                       onChange={(e) => setCellPhoneNumber(e.target.value)}></input>
                            </div>
                            <div className='d-grid col-6 mx-auto'>
                                <button onClick={() => validar()} className='btn btn-success'>
                                    <i className='fa-solid fa-floppy-disk'></i> Guardar
                                </button>
                            </div>
                        </div>
                        <div className='modal-footer'>
                            <button type='button' id='btnCerrar' className='btn btn-secondary'
                                    data-bs-dismiss='modal'>Cerrar
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Instructores;
