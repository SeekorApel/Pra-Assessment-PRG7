import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { listLayanan } from "../../util/LayananService";
import { saveTransaksi } from "../../util/TransaksiService";

export default function TransaksiCreate() {
  const navigate = useNavigate();
  const [idLayanan, setIdLayanan] = useState("");
  const [qty, setQty] = useState("");
  const [layanans, setLayanans] = useState([]);

  useEffect(() => {
    listLayanan()
      .then((response) => {
        setLayanans(response.data.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function handleSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const penjualanSalon = Object.fromEntries(formData.entries());

    if (!penjualanSalon.idLayanan || !penjualanSalon.qty) {
      alert("Field Tidak boleh kosong");
      retrun;
    }

    try {
      const penjualanSalon = {
        idLayanan,
        qty,
      };

      saveTransaksi(penjualanSalon).then(() => {
        navigate("/transaksi");
      });
    } catch (error) {
      alert("Tidak bisa terhubung dengan server");
    }
  }

  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-md-8 mx-auto rounded border p-4">
          <h2>Create Transaksi</h2>
          <form onSubmit={handleSubmit}>
            <div className="mb-3 row">
              <label className="col-sm-4 col-form-label">Nama Layanan</label>
              <div className="col-sm-8">
                <select className="form-select" name="idLayanan" id="idLayanan" value={idLayanan} onChange={(e) => setIdLayanan(e.target.value)}>
                  <option value="" disabled>
                    Pilih Kategori
                  </option>
                  {layanans.map((layanan) => (
                    <option key={layanan.idLayanan} value={layanan.idLayanan}>
                      {layanan.namaLayanan}
                    </option>
                  ))}
                </select>
                <span className="text-danger"></span>
              </div>
            </div>

            <div className="mb-3 row">
              <label className="col-sm-4 col-form-label">Qty</label>
              <div className="col-sm-8">
                <input className="form-control" type="number" name="qty" id="qty" value={qty} onChange={(e) => setQty(e.target.value)} />
                <span className="text-danger"></span>
              </div>
            </div>

            <div className="row">
              <div className="offset-sm-4 col-sm-4 d-grid">
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </div>
              <div className="col-sm-4 d-grid">
                <Link className="btn btn-secondary" to="/layanan" role="button">
                  Cancel
                </Link>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
