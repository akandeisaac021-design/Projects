import { useState } from 'react'

function App() {
  const [number, setNumber] = useState(null)
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)
  const [minValue, setMinValue] = useState(1)
  const [maxValue, setMaxValue] = useState(100)

  const API_BASE = import.meta.env.VITE_API_URL



const handleGenerate = async () => {
  setLoading(true)
  setError(null)
  try {
    const response = await fetch(`${API_BASE}/api/${minValue}/${maxValue}`)
    if (!response.ok) {
      throw new Error(`Request failed with status ${response.status}`)
    }
    const data = await response.json()
    setNumber(data.number)
  } catch (err) {
    setError('Could not reach the backend. Is it running on port 8000?')
  } finally {
    setLoading(false)
  }
}

  return (
    <div className="page">
      <div className="card">
        <h1>Random Number Generator</h1>
        <p className="subtitle">Click the button to fetch a random number from the backend.</p>

        <div className="result">
          {number !== null ? number : '—'}
        </div>

        <div className="input-group">
          <label htmlFor="minValue">Min value:</label>
          <input
            id="minValue"
            type="text"
            inputMode="numeric"
            value={minValue}
            onChange={(e) => {
              const raw = e.target.value.replace(/[^-\d]/g, '').replace(/(?!^)-/g, '')
              setMinValue(raw === '' || raw === '-' ? raw : Number(raw))
            }}
          />
        </div>

        <div className="input-group">
          <label htmlFor="maxValue">Max value:</label>
          <input
            id="maxValue"
            type="text"
            inputMode="numeric"
            value={maxValue}
            onChange={(e) => {
              const raw = e.target.value.replace(/[^-\d]/g, '').replace(/(?!^)-/g, '')
              setMaxValue(raw === '' || raw === '-' ? raw : Number(raw))
            }}
          />
        </div>

        <button onClick={handleGenerate} disabled={loading}>
          {loading ? 'Generating...' : 'Generate'}
        </button>

        {error && <p className="error">{error}</p>}      
      </div>
    </div>
  )
}


export default App
