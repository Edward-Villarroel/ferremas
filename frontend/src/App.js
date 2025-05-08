import React, { useState, useEffect } from 'react';
import './App.css';

function ButtonApi() {
  const [mostrarModal, setMostrarModal] = useState(false);
  const [clima, setClima] = useState(null);
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState(null);

  const toggleModal = () => {
    setMostrarModal(!mostrarModal);
  };

  //Lo de aqui abajo solo sirve para lo del clima
  const closeModal = () => {
    setMostrarModal(false);
    setClima(null);
    setError(null);
  };

  const interpretarcodigoWeatherApp = (code) => {
    const codigos = {
      0: 'Cielo despejado',
      1: 'Mayormente despejado',
      2: 'Parcialmente nublado',
      3: 'Nublado',
      45: 'Niebla',
      48: 'Niebla con escarcha',
      51: 'Llovizna ligera',
      53: 'Llovizna moderada',
      55: 'Llovizna intensa',
      61: 'Lluvia ligera',
      63: 'Lluvia moderada',
      65: 'Lluvia intensa',
      71: 'Nieve ligera',
      73: 'Nieve moderada',
      75: 'Nieve intensa',
      80: 'Chubascos ligeros',
      81: 'Chubascos moderados',
      82: 'Chubascos intensos',
      95: 'Tormenta',
      96: 'Tormenta con granizo ligero',
      99: 'Tormenta con granizo intenso',
    };
    return codigos[code] || 'Desconocido';
  };

  const fetchClima = async () => {
    setCargando(true);
    setError(null);
    try {
      const response = await fetch(
        'https://api.open-meteo.com/v1/forecast?latitude=-33.0246&longitude=-71.5518¤t=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m,wind_direction_10m,pressure_msl'
      );
      if (!response.ok) {
        throw new Error('Error al obtener los datos del clima');
      }
      const data = await response.json();
      setClima(data.current);
      setCargando(false);
    } catch (error) {
      setError(error.message);
      setCargando(false);
    }
  };

  useEffect(() => {
    if (mostrarModal) {
      fetchClima();
    }
  }, [mostrarModal]);
  //Esta wea de arriba hay que borrarla cuando saquemos la api del clima

  return (
    <div className="button-container">
        <button className="button-api" onClick={toggleModal}>
          Consulta el clima
        </button>

        {mostrarModal && (
          <div className="modal-overlay" onClick={closeModal}>
            <div className="modal-api" onClick={(e) => e.stopPropagation()}>
              <h2>Clima en Viña del Mar</h2>
              {cargando && <p>Cargando...</p>}
              {error && <p className="error">Error: {error}</p>}
              {clima && !cargando && !error && (
                <div className="clima-info">
                  <p>
                    <strong>Condición:</strong>{' '}
                    {interpretarcodigoWeatherApp(clima.weather_code)}
                  </p>
                  <p>
                    <strong>Temperatura:</strong> {clima.temperature_2m}°C
                  </p>
                  <p>
                    <strong>Humedad:</strong> {clima.relative_humidity_2m}%
                  </p>
                  <p>
                    <strong>Viento:</strong> {clima.wind_speed_10m} km/h (Dirección: {clima.wind_direction_10m}°)
                  </p>
                  <p>
                    <strong>Presión:</strong> {clima.pressure_msl} hPa
                  </p>
                </div>
              )}
              {!cargando && !error && !clima && (
                <p>No se encontraron datos del clima.</p>
              )}
              <div className="modal-buttons">
                <button
                  className="update-button"
                  onClick={fetchClima}
                  disabled={cargando}
                >
                  {cargando ? 'Actualizando...' : 'Actualizar Clima'}
                </button>
                <button className="modal-close" onClick={closeModal}>
                  Cerrar
                </button>
              </div>
            </div>
          </div>
        )}
      </div>
  );
}

function TitleApp() {
  return <h1 className="title-app">Ejemplo Consumo de API</h1>;
}

export default function App() {
  return (
    <div>
      <div className="title-container">
        <TitleApp />
      </div>
      <ButtonApi />
    </div>
  );
}