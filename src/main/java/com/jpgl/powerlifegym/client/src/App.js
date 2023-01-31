import { BrowserRouter, Routes, Route,  } from "react-router-dom";
import Clientes from "./components/Clientes";
import React, { Component } from "react";

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
