import { BrowserRouter, Routes, Route,  } from "react-router-dom";
import Clientes from "./components/Clientes.jsx";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Clientes/>}/>
            </Routes>
        </BrowserRouter>

    )
}

export default App;
