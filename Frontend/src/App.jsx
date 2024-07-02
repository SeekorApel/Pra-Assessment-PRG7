import { useState } from "react";
import Navbar from "./component/layout";
import Home from "./page/Home";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import NotFound from "./page/NotFound";
import LayananIndex from "./page/layanan/LayananIndex";
import LayananCreate from "./page/layanan/LayananCreate";
import LayananUpdate from "./page/layanan/LayananUpdate";
import TransaksiIndex from "./page/transaksi/TransaksiIndex";
import TransaksiCreate from "./page/transaksi/TransaksiCreate";
import LaporanIndex from "./page/laporan/LaporanIndex";

function App() {
  const [count, setCount] = useState(0);

  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/layanan" element={<LayananIndex />} />
        <Route path="/layanan/create" element={<LayananCreate />} />
        <Route path="/layanan/update/:idLayanan" element={<LayananUpdate />} />
        <Route path="/transaksi" element={<TransaksiIndex />} />
        <Route path="/transaksi/create" element={<TransaksiCreate />} />
        <Route path="/laporan" element={<LaporanIndex />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
