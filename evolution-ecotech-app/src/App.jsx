import React, { useState } from 'react';
import './EvolutionEcotech.css';

/* -----------------------------------------------------------
   Icons — a single restrained line-icon set (24x24, stroke only)
------------------------------------------------------------ */
const ICONS = {
  search: 'M15.5 15.5 20 20M11 17a6 6 0 1 0 0-12 6 6 0 0 0 0 12Z',
  layers: 'm3 9 9-5 9 5-9 5-9-5Zm0 6 9 5 9-5M3 12l9 5 9-5',
  trophy: 'M7 4h10v4a5 5 0 0 1-10 0V4Zm10 1h2a3 3 0 0 1-3 3M7 5H5a3 3 0 0 0 3 3m2 9v3m4-3v3M8 20h8',
  chart: 'M4 20V10m6 10V4m6 16v-7',
  laptop: 'M4 5h16v10H4V5Zm-2 13h20l-2 2H4l-2-2Z',
  heart: 'M12 20s-7-4.4-9.3-9A5 5 0 0 1 12 6a5 5 0 0 1 9.3 5c-2.3 4.6-9.3 9-9.3 9Z',
  card: 'M3 6h18v12H3V6Zm0 4h18',
  cap: 'm12 4 10 5-10 5L2 9l10-5Zm-6 7v4c0 1.5 2.7 3 6 3s6-1.5 6-3v-4',
  landmark: 'M4 21h16M5 21V10m4 11V10m6 11V10m4 11V10M3 10l9-6 9 6M3 10h18',
  scale: 'M12 3v18M7 7l-4 8a4 4 0 0 0 8 0l-4-8Zm10 0-4 8a4 4 0 0 0 8 0l-4-8ZM5 7h6M13 7h6',
  bag: 'M6 8h12l1 12H5L6 8Zm3 0V6a3 3 0 0 1 6 0v2',
  bolt: 'M13 2 4 14h6l-1 8 9-12h-6l1-8Z',
  truck: 'M2 7h11v9H2V7Zm11 3h4l3 3v3h-7v-6ZM6 19a2 2 0 1 0 0-4 2 2 0 0 0 0 4Zm11 0a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z',
  sprout: 'M12 21v-8m0 0C7 13 4 10 4 6c4 0 7 3 8 7Zm0 0c1-4 4-7 8-7 0 4-3 7-8 7Z',
  film: 'M4 4h16v16H4V4Zm4 0v16m8-16v16M4 9h4m8 0h4M4 15h4m8 0h4',
  factory: 'M3 21V11l5 3v-3l5 3V7l5 4v10H3Zm4-4h2m4 0h2',
  globe: 'M12 21a9 9 0 1 0 0-18 9 9 0 0 0 0 18Zm-9-9h18M12 3a13 13 0 0 1 0 18 13 13 0 0 1 0-18Z',
  people: 'M9 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm7-1a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5ZM2 20c0-3 3-5 7-5s7 2 7 5m1-6c2.5 0 5 1.6 5 4v2h-4',
  bulb: 'M9 18h6M10 21h4M7 9a5 5 0 1 1 10 0c0 2-1 3-2 4.2-.6.7-1 1.4-1 2.3v.5H10v-.5c0-.9-.4-1.6-1-2.3C8 12 7 11 7 9Z',
};

function Icon({ name, size = 22 }) {
  const d = ICONS[name];
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.6" strokeLinecap="round" strokeLinejoin="round">
      {d.split('M').filter(Boolean).map((seg, i) => (
        <path key={i} d={'M' + seg} />
      ))}
    </svg>
  );
}

/* Ring badge — the signature "growth ring" motif, reused for every icon slot */
function RingBadge({ icon, tone = 'amber' }) {
  const stroke = tone === 'dark' ? '#f6f1e6' : '#b14300';
  const dim = tone === 'dark' ? 'rgba(246,241,230,0.35)' : 'rgba(177,67,0,0.25)';
  return (
    <div className="ring-badge">
      <svg viewBox="0 0 56 56" width="56" height="56">
        <circle cx="28" cy="28" r="26" fill="none" stroke={dim} strokeWidth="1" />
        <circle cx="28" cy="28" r="21" fill="none" stroke={dim} strokeWidth="1" />
        <circle cx="28" cy="28" r="16" fill="none" stroke={stroke} strokeWidth="1.4" strokeDasharray="2 4" />
      </svg>
      <div style={{ position: 'absolute', color: stroke }}>
        <Icon name={icon} size={20} />
      </div>
    </div>
  );
}

/* Decorative concentric ring field used in the hero */
function HeroRings() {
  const rings = [340, 280, 220, 160, 100];
  return (
    <svg className="ee-hero-rings" viewBox="0 0 780 780" aria-hidden="true">
      {rings.map((r, i) => (
        <circle
          key={r}
          className={i % 2 === 0 ? 'r2' : 'r3'}
          cx="390" cy="390" r={r}
          fill="none"
          stroke={i === 2 ? '#efa93a' : 'rgba(246,241,230,0.18)'}
          strokeWidth={i === 2 ? 1.5 : 1}
          strokeDasharray={i % 3 === 0 ? '3 10' : undefined}
        />
      ))}
      <circle cx="390" cy="390" r="4" fill="#efa93a" />
    </svg>
  );
}

/* -----------------------------------------------------------
   Content data
------------------------------------------------------------ */
const NAV = [
  { id: 'home', label: 'Home' },
  { id: 'about', label: 'About' },
  { id: 'services', label: 'Services' },
  { id: 'sectors', label: 'Sectors' },
  { id: 'testimonials', label: 'Testimonials' },
  { id: 'faqs', label: 'FAQs' },
];

const ABOUT_FEATURES = [
  { icon: 'bulb', title: 'Sector-Specific Expertise', text: 'Deep understanding of every tech-enabled sector we serve.', dark: true },
  { icon: 'sprout', title: 'Talent-First Approach', text: 'We focus on people, building long-term value with every hire.' },
  { icon: 'bolt', title: 'Speed Meets Precision', text: 'Top-tier candidates delivered fast, without compromise.' },
  { icon: 'globe', title: 'Global Reach, Local Insight', text: 'We match global talent to your mission with a local touch.' },
];

const SERVICES = [
  { icon: 'search', title: 'Talent Sourcing', text: 'We identify, vet, and connect top professionals across Tech, Banking, and Health.' },
  { icon: 'layers', title: 'Outsourcing Solutions', text: 'Flexible staffing models for project-based or long-term growth needs.' },
  { icon: 'trophy', title: 'Executive Search', text: 'We find visionary leaders with the skills and mindset to drive change.' },
  { icon: 'chart', title: 'Industry Advisory', text: 'Insightful strategies that align your hiring goals with market trends.' },
];

const SECTORS = [
  { icon: 'laptop', name: 'Tech & SaaS', text: 'Skilled teams pushing the boundaries of software, AI, and data analytics.', tags: ['Industries', 'Innovators'] },
  { icon: 'heart', name: 'Healthcare', text: 'Digital transformation in patient care and telemedicine integration.', tags: ['Industries', 'Public Sector'] },
  { icon: 'card', name: 'Banking', text: 'Fintech expertise that optimizes digital banking experiences.', tags: ['Industries', 'Services'] },
  { icon: 'cap', name: 'Education', text: 'Personalized, accessible EdTech tools for global learning.', tags: ['Public Sector'] },
  { icon: 'landmark', name: 'Government', text: 'Technology that promotes civic engagement and digital inclusion.', tags: ['Public Sector'] },
  { icon: 'scale', name: 'Legal', text: 'Modernizing legal practice with secure digital platforms.', tags: ['Services', 'Public Sector'] },
  { icon: 'bag', name: 'Retail & E-Commerce', text: 'AI-driven inventory and sales management for digital commerce.', tags: ['Innovators', 'Services'] },
  { icon: 'bolt', name: 'Energy', text: 'Smart, data-driven energy management and consumption systems.', tags: ['Industries'] },
  { icon: 'truck', name: 'Logistics', text: 'Route optimization and real-time tracking across the supply chain.', tags: ['Services'] },
  { icon: 'sprout', name: 'Agriculture', text: 'Agri-tech that boosts productivity and sustainable farming.', tags: ['Industries'] },
  { icon: 'film', name: 'Media & Entertainment', text: 'Interactive tech for content creation and audience engagement.', tags: ['Innovators'] },
  { icon: 'factory', name: 'Manufacturing', text: 'Industry 4.0 standards with IoT, AI, and robotics.', tags: ['Industries'] },
];

const FILTERS = ['All', 'Industries', 'Services', 'Public Sector', 'Innovators'];

const TESTIMONIALS = [
  { quote: 'Evolution Ecotech found us exceptional developers who\u2019ve accelerated our product roadmap. Their speed and accuracy are unmatched.', stars: 5, name: 'Amara Daniels', role: 'Head of Talent, Northbridge Labs (Tech Sector)', initials: 'AD', tone: '#b14300' },
  { quote: 'They understood our unique requirements in banking compliance and delivered top-tier talent who fit right in culturally.', stars: 4, name: 'Idris Kareem', role: 'HR Lead, SecureBank (Banking Sector)', initials: 'IK', tone: '#5c6b3f' },
  { quote: 'A recruitment partner that actually listens. Every candidate they sent understood both the clinical and the technical side of our work.', stars: 5, name: 'Dr. Philip Mensah', role: 'Director, Medisphere Clinics (Health Sector)', initials: 'PM', tone: '#c67f0e' },
];

const FAQS = [
  { q: 'What industries does Evolution Ecotech specialize in?', a: 'We focus on three core sectors — Tech, Banking, and Health — leveraging deep industry insight to find the right talent for every role.' },
  { q: 'Do you work with companies outside of Nigeria?', a: 'Yes, we operate globally. While we understand local markets, we also connect professionals to opportunities across borders.' },
  { q: 'How long does it take to fill a position?', a: 'Our average placement timeline is 7\u201314 business days, depending on role complexity and candidate availability.' },
  { q: 'Do you provide both permanent and contract staffing?', a: 'Absolutely. Whether you need full-time employees or short-term consultants, we\u2019ve got you covered.' },
  { q: 'How do you ensure candidate quality and cultural fit?', a: 'We follow a talent-first approach, combining in-depth screening with sector-specific knowledge to match not just skills, but values too.' },
  { q: 'Can individuals apply directly through your platform?', a: 'Yes. Talented professionals can submit their CVs or apply to open roles through our contact form or job portal (coming soon).' },
];

const STATS = [
  { num: '100+', label: 'Hires made' },
  { num: '3', label: 'Core sectors' },
  { num: '95%', label: 'Retention rate' },
  { num: '5+', label: 'Years experience' },
];

/* -----------------------------------------------------------
   Component
------------------------------------------------------------ */
export default function App() {
  const [menuOpen, setMenuOpen] = useState(false);
  const [activeFilter, setActiveFilter] = useState('All');
  const [openFaq, setOpenFaq] = useState(0);

  const visibleSectors =
    activeFilter === 'All' ? SECTORS : SECTORS.filter((s) => s.tags.includes(activeFilter));

  const go = (id) => (e) => {
    e.preventDefault();
    setMenuOpen(false);
    document.getElementById(id)?.scrollIntoView({ behavior: 'smooth' });
  };

  return (
    <div className="ee-root">
      {/* Header */}
      <header className="ee-header">
        <div className="ee-container ee-header-inner">
          <a href="#home" className="ee-logo" onClick={go('home')}>
            <span className="ee-logo-mark" />
            Evolution<span>Ecotech</span>
          </a>
          <nav className="ee-nav-links">
            {NAV.map((n) => (
              <a key={n.id} href={`#${n.id}`} onClick={go(n.id)} className={n.id === 'home' ? 'is-active' : ''}>
                {n.label}
              </a>
            ))}
          </nav>
          <a href="#contact" className="ee-btn ee-btn--primary ee-header-cta" onClick={go('faqs')}>
            Hire Talent
          </a>
          <button className="ee-burger" aria-label="Open menu" onClick={() => setMenuOpen(true)}>
            <svg width="18" height="14" viewBox="0 0 18 14" fill="none" stroke="currentColor" strokeWidth="1.6" strokeLinecap="round">
              <path d="M1 1h16M1 7h16M1 13h16" />
            </svg>
          </button>
        </div>
      </header>

      {/* Mobile drawer */}
      <div className={`ee-drawer ${menuOpen ? 'is-open' : ''}`}>
        <button className="ee-drawer-close" aria-label="Close menu" onClick={() => setMenuOpen(false)}>
          <svg width="16" height="16" viewBox="0 0 16 16" fill="none" stroke="currentColor" strokeWidth="1.6" strokeLinecap="round">
            <path d="M1 1l14 14M15 1 1 15" />
          </svg>
        </button>
        {NAV.map((n) => (
          <a key={n.id} href={`#${n.id}`} onClick={go(n.id)}>
            {n.label}
          </a>
        ))}
      </div>

      {/* Hero */}
      <section className="ee-hero" id="home">
        <HeroRings />
        <div className="ee-container ee-hero-grid">
          <div>
            <span className="ee-eyebrow" style={{ color: '#efa93a' }}>
              Expert hiring, fast &amp; people-first
            </span>
            <h1 className="ee-hero-title">
              Connecting <em>top talent</em> with leading industries
            </h1>
            <p className="ee-hero-sub">
              Evolution Ecotech sources and outsources exceptional professionals across every tech-enabled sector — matched fast, matched right.
            </p>
            <div className="ee-hero-actions">
              <a href="#sectors" className="ee-btn ee-btn--primary" onClick={go('sectors')}>Find Talent</a>
              <a href="#faqs" className="ee-btn ee-btn--ghost-dark" onClick={go('faqs')}>Join Our Talent Network</a>
            </div>
            <div className="ee-avatars">
              <div className="ee-avatar-stack">
                {['#efa93a', '#b14300', '#5c6b3f', '#c67f0e'].map((c, i) => (
                  <span key={i} style={{ background: c, color: '#fff' }}>{['A', 'B', 'C', 'D'][i]}</span>
                ))}
              </div>
              <span className="ee-avatars-label">100+ talents recruited</span>
            </div>
          </div>

          <div className="ee-hero-panel">
            <div className="ee-hero-panel-top">
              <span className="ee-hero-panel-title">Growth, by the numbers</span>
              <RingBadge icon="chart" tone="dark" />
            </div>
            <div className="ee-stat-grid">
              {STATS.map((s) => (
                <div className="ee-stat-card" key={s.label}>
                  <div className="ee-stat-num">{s.num}</div>
                  <div className="ee-stat-label">{s.label}</div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </section>

      {/* About */}
      <section className="ee-section ee-section--cream" id="about">
        <div className="ee-container">
          <div className="ee-about-top">
            <div className="ee-ring-visual">
              <svg viewBox="0 0 400 400" width="100%" height="100%">
                <circle cx="200" cy="200" r="180" fill="none" stroke="rgba(43,27,16,0.1)" />
                <circle cx="200" cy="200" r="140" fill="none" stroke="rgba(177,67,0,0.18)" />
                <circle cx="200" cy="200" r="100" fill="none" stroke="rgba(239,169,58,0.4)" strokeDasharray="3 8" />
                <circle cx="200" cy="200" r="60" fill="#b14300" opacity="0.08" />
                <circle cx="200" cy="200" r="14" fill="#b14300" />
                <circle cx="330" cy="200" r="6" fill="#efa93a" />
                <circle cx="200" cy="60" r="6" fill="#5c6b3f" />
                <circle cx="90" cy="300" r="6" fill="#c67f0e" />
              </svg>
            </div>
            <div className="ee-about-copy">
              <span className="ee-eyebrow">About Evolution Ecotech</span>
              <h2 className="ee-h2">Bridging bold ideas with <em>exceptional talent</em></h2>
              <p>
                Evolution Ecotech is a modern recruitment consultancy connecting high-performing professionals with leading opportunities across every tech-enabled sector. We bring sector-specific expertise, a talent-first mindset, global reach, and fast, precise hiring solutions to help organizations scale and innovate with the right people.
              </p>
              <div className="ee-pill-row">
                <span className="ee-pill"><i />100+ Hires Made</span>
                <span className="ee-pill"><i />3 Core Sectors</span>
                <span className="ee-pill"><i />95% Retention Rate</span>
                <span className="ee-pill"><i />5+ Years Experience</span>
              </div>
            </div>
          </div>

          <div className="ee-card-grid ee-card-grid--4">
            {ABOUT_FEATURES.map((f) => (
              <div className={`ee-card ${f.dark ? 'ee-card--dark' : ''}`} key={f.title}>
                <RingBadge icon={f.icon} tone={f.dark ? 'dark' : 'amber'} />
                <div className="ee-card-title">{f.title}</div>
                <div className="ee-card-text">{f.text}</div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Services */}
      <section className="ee-section ee-section--paper" id="services">
        <div className="ee-container">
          <div className="ee-head ee-head--center">
            <span className="ee-eyebrow">What we do</span>
            <h2 className="ee-h2">Connecting talent to the industries <em>shaping tomorrow</em></h2>
          </div>
          <div className="ee-services-grid">
            {SERVICES.map((s) => (
              <div className="ee-card" key={s.title}>
                <RingBadge icon={s.icon} />
                <div className="ee-card-title">{s.title}</div>
                <div className="ee-card-text">{s.text}</div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Sectors */}
      <section className="ee-section ee-section--dim" id="sectors">
        <div className="ee-container">
          <div className="ee-head ee-head--center">
            <span className="ee-eyebrow">All business sectors</span>
            <h2 className="ee-h2">Empowering industries through <em>tailored talent</em></h2>
            <p className="ee-lede">Tech-driven staffing solutions built for digital transformation and growth, wherever your business operates.</p>
          </div>

          <div className="ee-filters">
            {FILTERS.map((f) => (
              <button key={f} className={`ee-filter-chip ${activeFilter === f ? 'is-active' : ''}`} onClick={() => setActiveFilter(f)}>
                {f}
              </button>
            ))}
          </div>

          <div className="ee-sector-grid">
            {visibleSectors.map((s) => (
              <div className="ee-sector-card" key={s.name}>
                <RingBadge icon={s.icon} />
                <div className="ee-sector-name">{s.name}</div>
                <div className="ee-sector-text">{s.text}</div>
              </div>
            ))}
          </div>

          <div className="ee-cta-banner">
            <p>Looking for experts in your industry? We match top-tier talent to your business goals.</p>
            <a href="#faqs" className="ee-btn ee-btn--primary" onClick={go('faqs')}>Find Talent in Your Sector</a>
          </div>
        </div>
      </section>

      {/* Testimonials */}
      <section className="ee-section ee-section--cream" id="testimonials">
        <div className="ee-container">
          <div className="ee-head ee-head--center">
            <span className="ee-eyebrow">What our clients say</span>
            <h2 className="ee-h2">Trusted across every <em>sector we serve</em></h2>
          </div>
          <div className="ee-testimonial-grid">
            {TESTIMONIALS.map((t) => (
              <div className="ee-testi-card" key={t.name}>
                <span className="ee-stars">{'★'.repeat(t.stars)}{'☆'.repeat(5 - t.stars)}</span>
                <p className="ee-quote">&ldquo;{t.quote}&rdquo;</p>
                <div className="ee-testi-person">
                  <div className="ee-testi-avatar" style={{ background: t.tone }}>{t.initials}</div>
                  <div>
                    <div className="ee-testi-name">{t.name}</div>
                    <div className="ee-testi-role">{t.role}</div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* FAQs */}
      <section className="ee-section ee-section--paper" id="faqs">
        <div className="ee-container">
          <div className="ee-head ee-head--center">
            <span className="ee-eyebrow">Frequently asked questions</span>
            <h2 className="ee-h2">Answers, <em>upfront</em></h2>
            <p className="ee-lede">Can&rsquo;t find what you&rsquo;re looking for? Reach out and we&rsquo;ll get back to you directly.</p>
          </div>
          <div className="ee-faq-panel">
            {FAQS.map((f, i) => (
              <div className={`ee-faq-item ${openFaq === i ? 'is-open' : ''}`} key={f.q}>
                <button className="ee-faq-q" onClick={() => setOpenFaq(openFaq === i ? -1 : i)}>
                  {f.q}
                  <span className="ee-faq-q-icon">+</span>
                </button>
                <div className="ee-faq-a">
                  <p>{f.a}</p>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="ee-footer">
        <div className="ee-container">
          <div className="ee-footer-grid">
            <div className="ee-footer-brand">
              <a href="#home" className="ee-logo" onClick={go('home')}>
                <span className="ee-logo-mark" />
                Evolution<span>Ecotech</span>
              </a>
              <p>Bridging bold ideas with exceptional talent in Tech, Banking &amp; Health.</p>
            </div>
            <div>
              <div className="ee-footer-heading">Quick Links</div>
              <ul className="ee-footer-links">
                {NAV.map((n) => (
                  <li key={n.id}><a href={`#${n.id}`} onClick={go(n.id)}>{n.label}</a></li>
                ))}
              </ul>
            </div>
            <div>
              <div className="ee-footer-heading">Contact</div>
              <ul className="ee-footer-contact">
                <li>Email: <a href="mailto:hello@evolutionecotech.com">hello@evolutionecotech.com</a></li>
                <li>Phone: +123-456-7890</li>
                <li>Location: Global reach with local presence</li>
              </ul>
            </div>
            <div>
              <div className="ee-footer-heading">Stay Connected</div>
              <form className="ee-newsletter" onSubmit={(e) => e.preventDefault()}>
                <input type="email" required placeholder="Enter your email" />
                <button type="submit" className="ee-btn ee-btn--primary ee-btn--block">Subscribe</button>
              </form>
            </div>
          </div>
          <div className="ee-footer-bottom">© {new Date().getFullYear()} Evolution Ecotech. All rights reserved.</div>
        </div>
      </footer>
    </div>
  );
}
