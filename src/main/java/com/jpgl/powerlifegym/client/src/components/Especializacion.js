import React, {useEffect, useState} from "react";
import axios from 'axios';
import Swal from 'sweetalert2';
import withReactContent from "sweetalert2-react-content";
import {show_alert} from './Functions';
import { endPoint } from './Config';

const resource = '/specialization'

const Especializacion = () => {
    let url = endPoint + resource;
    const [especializaciones, setEspecializaciones] = useState([]);
    const [id, setId] = useState('');
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [operation, setOperation] = useState('');
    const [title, setTitle] = useState('');


    useEffect(() => {
        getEspecializaciones().then(() => null)
    }, []);

    const getEspecializaciones = async () => {
        const respuesta = await axios.get(url).then(respuesta => {
            setEspecializaciones(respuesta.data);
        });
    }

    const openModal = (op, id, name, description) => {
        setId('');
        setName('');
        setDescription('');
        setOperation(op);
        if (op === 1) {
            setTitle('Registrar Especialización');
        } else if (op === 2) {
            setTitle('Editar Especialización');
            setId(id);
            setName(name);
            setDescription(description);
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
        } else if (description.trim() === '') {
            show_alert('Escriba un nombre', 'warning');
        } else {
            if (operation === 1) {
                parametros = {
                    id: id,
                    name: name.trim(),
                    description: description.trim(),
                };
                metodo = 'post';
                url = endPoint + resource
            } else {
                parametros = {
                    id: id,
                    name: name.trim(),
                    description: description.trim(),
                };
                metodo = 'put';
                url = endPoint + resource + "/" + id.toString()
            }
            enviarSolicitud(metodo, parametros).then(() => null);
            console.log(parametros)
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
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody className="table-group-divider">
                                {especializaciones.map((especializacion, i) => (
                                    <tr key={especializacion.id}>
                                        <td>{especializacion.id}</td>
                                        <td>{especializacion.name}</td>
                                        <td>{especializacion.description}</td>
                                        <td>
                                            <button
                                                onClick={() => openModal(2, especializacion.id, especializacion.name, especializacion.description)}
                                                className='btn btn-warning' data-bs-toggle='modal'
                                                data-bs-target='#modalClients'>
                                                <i className="fa-solid fa-edit"></i>
                                            </button>
                                            &nbsp;
                                            <button onClick={()=>deleteClient(especializacion.id,especializacion.name)} className="btn btn-danger">
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
                                <span className='input-group-text'><i className='fa-solid fa-person'></i></span>
                                <input type='text' id='nombre' className='form-control' placeholder='Nombre'
                                       value={name}
                                       onChange={(e) => setName(e.target.value)}></input>
                            </div>
                            <div className='input-group mb-3'>
                                <span className='input-group-text'><i className='fa-solid fa-person'></i></span>
                                <input type='text' id='descripcion' className='form-control' placeholder='descripcion'
                                       value={description}
                                       onChange={(e) => setDescription(e.target.value)}></input>
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

export default Especializacion;
