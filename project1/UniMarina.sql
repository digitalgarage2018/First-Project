-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Apr 29, 2018 alle 19:25
-- Versione del server: 5.7.22-0ubuntu0.16.04.1
-- Versione PHP: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `UniMarina`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `exam`
--

CREATE TABLE `exam` (
  `idExam` bigint(32) NOT NULL,
  `name` varchar(45) NOT NULL,
  `credits` varchar(45) NOT NULL,
  `description` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `exam`
--

INSERT INTO `exam` (`idExam`, `name`, `credits`, `description`) VALUES
(1, 'Diritto del lavoro dell’Unione Europea', '6', 'Durante il corso saranno affrontate le seguenti tematiche, quali: i principi e le fonti del diritto del lavoro dell’Unione europea; il rapporto tra diritto comunitario e diritto nazionale; la libera circolazione dei lavoratori subordinati; l’igiene e la sicurezza sul lavoro; la parità di trattamento e i divieti di discriminazione; l’armonizzazione della legislazione degli stati membri in materia di rapporto di lavoro; la partecipazione dei lavoratori alla gestione dell’impresa.'),
(2, 'Diritto del lavoro e della previdenza sociale', '6', 'Stato sociale e previdenza sociale. Sistemi previdenziali e modelli ordinamentali. Evoluzione storica del sistema previdenziale italiano: art. 38 Cost. Il rapporto giuridico previdenziale. Il rapporto giuridico assistenziale. Obbligazione contributiva. La prestazione previdenziale. Assicurazione contro gli infortuni sul lavoro e le malattie professionali. Assicurazione contro la invalidità, la vecchiaia e i superstiti. Rapporto previdenziale e malattia. Rapporto previdenziale e reddito familiare. Gli ammortizzatori sociali. Le prestazioni di assistenza sociale.'),
(3, 'Diritto delle forniture', '6', 'Il programma ha ad oggetto lo studio dei contratti di fornitura tra soggetti professionali, come regolati dalle norme di diritto privato e dalle norme del codice dei contratti pubblici'),
(4, 'Diritto industriale', '6', 'Il programma ha ad oggetto lo studio dei contratti in ambito industriale'),
(5, 'Diritto pubblico della Economia', '6', 'Il programma ha ad oggetto lo studio del diritto pubblico applicato ad aspetti economici'),
(6, 'Diritto regionale e degli enti locali', '6', 'Il modello francese dello Stato unitario centralizzato; il modello federale nordamericano: il passaggio dalla Confederazione allo Stato federale; la questione della sovranità; i processi federativi in Europa nel XIX e nella prima parte del XX secolo; l’unificazione nazionale italiana e l’accoglimento del modello francese; la nascita del modello regionale: la Costituzione spagnola del 1931; l’accoglimento del modello regionale da parte della Costituzione italiana del 1947'),
(7, 'Diritto sindacale e del lavoro', '6', 'La libertà e la attività sindacale; il contratto collettivo; il conflitto collettivo; la repressione della condotta antisidacale; Lavoro subordinato e altri tipi di lavoro'),
(8, 'Diritto tributario', '6', 'Principi costituzionali; efficacia, applicazione e interpretazione della norma tributaria; nascita ed attuazione della obbligazione tributaria; soggettività tributaria attiva e passiva; accertamento, al riscossione, il rimborso, le sanzioni amministrative tributarie; il processo tributario'),
(9, 'Diritto urbanistico', '6', 'La disciplina del territorio. Urbanistica al governo del territorio. Urbanistica e Costituzione. La pianificazione urbanistica. I vari tipi di piano. Piani di area vasta.'),
(10, 'Economia degli intermediatri finanziari', '6', 'Il Corso si propone in primo luogo di fornire una visione d’insieme del ruolo e delle principali caratteristiche e componenti del sistema finanziario. La parte centrale del Corso è dedicata ad un’analisi delle caratteristiche tecniche e dei profili economici e gestionali degli strumenti finanziari e dei servizi di pagamento. Il Corso presenta infine le principali tipologie e modelli  di gestione degli intermediari finanziari.'),
(11, 'Economia della Unione Europea', '6', 'Il Corso si propone di fornire una visione d’insieme sull’Unione Europea, la sua storia, le sue Istituzioni e il bilancio della UE'),
(12, 'Economia della corruzione e dei mercati', '6', '” in relazione ai differenti contesti istituzionali, il sistema di incentivi e disincentivi legato alle politiche di contrasto, le relazioni tra mercato della corruzione e mercati illegali e criminali.'),
(13, 'Economia della qualità e dela sicurezza', '6', 'Il concetto di qualità applicato alla gestione delle organizzazioni (imprese e non) La sua evoluzione storica L’applicazione delle principali metodologie di gestione della qualità alla realtà delle organizzazioni con specifico riferimento ai contenuti della normativa internazionale ISO 9000 I Requisiti contenuti nel modello ISO 9001 Introduzione ai sistemi di gestione complementari alla gestione della qualità: il sistema di gestione ambientale, il sistema di gestione della sicurezza, il sistema di gestione etico.'),
(14, 'Economia delle aziende', '6', 'L’obiettivo principale del Corso è fornire un quadro di riferimento generale sullo stato dell’arte del Sistema di Aziende ed Amministrazioni Pubbliche in Italia e sulla diffusione di logiche manageriali, secondo un approccio aziendale.'),
(15, 'Economia delle migrazioni', '6', 'Scenario mondiale, popolazione, sviluppo e migrazione, Flussi nel mondo ed in Europa, Convenzioni internazionali, Accordi, Trattati bilaterali principali, Migrazioni Circolari, Migrazioni in Italia: alcuni Paesi di provenienza Asia, Africa ed America Latina, Tratta e discriminazioni, Costi e benefici della immigrazione'),
(16, 'Economia e gestione della innovazione', '6', 'Il corso si struttura su una prima parte di inquadramento delle problematiche generali di gestione dell’innovazione per poi approfondire nella seconda parte aspetti specifici legati all’Open Innovation.'),
(17, 'Economia e gestione delle imprese', '6', 'Il corso studia il governo, la gestione, la direzione e l’organizzazione delle imprese con riferimento alle relazioni reciproche che esse intrattengono con l’ambiente. Esso adotta il metodo dell’analisi sistemica e fa ricorso congiuntamente all’impostazione evoluzionistica classica e contemporanea, offrendo un aggiornato punto di vista delle dinamiche competitive, di adattamento ed evolutive delle imprese in ambienti complessi.'),
(18, 'Economia e gestione dei commerci', '6', 'Obiettivi di apprendimento del corso: lo sviluppo delle imprese commerciali verso formule sempre più differenziate, e a volte anche di notevoli dimensioni aziendali, rende ormai necessario un insegnamento centrato sulle specificità di questo settore. Il corso mira a trasmettere la conoscenza e sviluppare le capacità di comprensione degli studenti in merito al settore della distribuzione commerciale e dei principi gestionali delle imprese che vi appartengono.'),
(19, 'Economiaa intervento pubblico', '6', 'Obiettivi di apprendimento del corso: macroeconomia, incertezza e politica economica, aspettative dei mercati dei beni e dei servizi, moltiplicatori di politica fiscale'),
(20, 'Economia industriale', '6', 'Concetto di probabilità e teoria dell’utilità attesa; Regole del gioco; Rappresentazione dei giochi; Strategie pure e strategie miste; Ruolo dell’informazione: completa-incompleta.  Giochi non-cooperativi e a somma costante.'),
(21, 'Economia italiana ed europea', '6', 'I principali obiettivi del corso sono:fornire una conoscenza e una comprensione dell’evoluzione dell’economia italiana negli ultimi venti anni e delle sue caratteristiche strutturali; far comprendere, attraverso il confronto tra l’economia italiana e quella dei principali paesi europei, le opportunità e le sfide legate alla specializzazione del sistema produttivo nazionale; illustrare gli obiettivi delle politiche economiche perseguite a livello nazionale, di Unione Europea e di Unione Monetaria Europea'),
(22, 'Finanziamenti aziendali', '6', 'Il Corso analizza gli strumenti e le tecniche degli intermediari finanziari che supportano la copertura dei fabbisogni finanziari delle imprese.'),
(23, 'Geografia economica', '6', 'Programma dell’insegnamento: Introduzione al corso e formazione del lessico comune, modellistica geografico-economico e territoriale, la lettura geografico-economica dello sviluppo 2020.'),
(24, 'Informatica', '6', 'Al termine del corso gli studenti dovranno aver acquisito i concetti fondamentali delle Tecnologie dell’Informazione e della Comunicazione (ICT) e dovranno aver conseguito conoscenze e capacità di utilizzo  in relazione ai  seguenti ambiti: hardware, software di sistema, software applicativo, reti, architetture client-server, web, sicurezza informatica, algoritmi, telematica, identità digitale di individui e aziende.'),
(25, 'Istituzioni di diritto romano', '6', 'Obiettivo del corso è fornire nozioni su diritto romano'),
(26, 'Lingua Francese', '6', 'Il corso di lingua francese di livello A2/B1 del quadro europeo propone un apprendimento più mirato del francese professionale per permettere allo studente di acquisire velocemente delle competenze per agire ed interagire nell’ambiente francofono o con degli interlocutori francofoni attraverso dei “repères culturels”. Lo scopo è di portare lo studente all’autonomia linguistica tramite la realizzazione di compiti concreti attraverso i “repères professionnels” per comprendere i documenti e i codici lavorativi.'),
(27, 'Managment dei servizi pubblici', '6', 'Obiettivo del corso è acquisire le competenze e le abilità metodologiche necessarie per facilitare l’inserimento lavorativo nel settore dei servizi pubblici in contesti organizzativi differenti, sia come dipendenti che come consulenti. In particolare, gli studenti dovranno essere in grado di utilizzare le principali nozioni analizzate durante il corso negli specifici ambiti di competenza.'),
(28, 'Marketing', '6', 'Il corso si propone di analizzare i principi fondamentali del marketing management. Nello specifico, si discutono i principali strumenti per l’analisi di mercato (marketing analitico), per la definizione delle strategie di marketing (marketing strategico), per l’attuazione dei piani di marketing (marketing operativo).'),
(29, 'Organizzazione della pubblica amministrazione', '6', 'Il corso serve a fornire agli Studenti le principali categorie logiche e i concetti fondamentali dell’organizzazione delle aziende e delle pubbliche amministrazioni. I concetti teorici rilevanti per l’analisi e la gestione del cambiamento organizzativo includono le principali dimensioni strutturali e contestuali dell’azienda pubblica, quali la formalizzazione, la gerarchia, la specializzazione, la tecnologia, l’ambiente e la cultura. Il corso fornisce uno schema per “leggere” le condizione di efficienza ed efficacia di dette dimensione e, quindi, evidenziare spazi e modalità per una loro evoluzione'),
(30, 'Sistemi di contabilità economica e sociale', '6', 'Tra i compiti della statistica economica c’è quello di sviluppare concetti, definizioni, classificazioni e metodi per produrre informazioni statistiche che descrivano lo stato e l’andamento, nel tempo e nello spazio, dei fenomeni economici. Tali informazioni sono impiegate per analizzare i comportamenti degli operatori economici, effettuare previsioni sulla dinamica degli aggregati economici, prendere decisioni di politica economica ed aziendale, valutare pro e contro di investimenti alternativi, ecc.');

-- --------------------------------------------------------

--
-- Struttura della tabella `login`
--

CREATE TABLE `login` (
  `badgeNumber` int(11) NOT NULL,
  `istitutionalEmail` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `flagType` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `login`
--

INSERT INTO `login` (`badgeNumber`, `istitutionalEmail`, `password`, `flagType`) VALUES
(3, 'marinadelorenzo@docente.unimarina.it', 'asd123', 'D'),
(10006, 'qw.eqwrqwrw@studenti.unimarina.it', 'asd123', 'S'),
(11111, 'm.marina@docenti.unimarina.it', 'asd123', 'D'),
(12345, 'f.friz@studenti.unimarina.it', 'asd123', 'S'),
(12346, 'St.Ceccotti@studenti.unimarina.it', 'a', 'S');

-- --------------------------------------------------------

--
-- Struttura della tabella `plainofstudy`
--

CREATE TABLE `plainofstudy` (
  `idPlainOfStudy` bigint(32) NOT NULL,
  `idExam` bigint(32) NOT NULL,
  `mark` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `plainofstudy`
--

INSERT INTO `plainofstudy` (`idPlainOfStudy`, `idExam`, `mark`) VALUES
(1, 29, 0),
(1, 30, 0),
(1, 29, 0),
(1, 30, 0),
(1, 30, 0),
(1, 30, 0),
(1, 30, 0),
(1, 30, 0),
(1, 30, 0),
(1, 30, 0),
(2, 29, 0),
(2, 30, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `professor`
--

CREATE TABLE `professor` (
  `badgeNumber` bigint(32) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `istitutionalEmail` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `idExam` bigint(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `professor`
--

INSERT INTO `professor` (`badgeNumber`, `name`, `surname`, `istitutionalEmail`, `dateOfBirth`, `idExam`) VALUES
(1, 'Mario', 'Rossi', 'mariorossi@docente.unimarina.it', '1968-04-01', 1),
(1, 'Mario', 'Rossi', 'mariorossi@docente.unimarina.it', '1968-04-01', 2),
(1, 'Mario', 'Rossi', 'mariorossi@docente.unimarina.it', '1968-04-01', 3),
(2, 'Giulio', 'Sabatini', 'giuliosabatini@docente.unimarina.it', '1982-02-10', 4),
(2, 'Giulio', 'Sabatini', 'giuliosabatini@docente.unimarina.it', '1982-02-10', 5),
(2, 'Giulio', 'Sabatini', 'giuliosabatini@docente.unimarina.it', '1982-02-10', 6),
(3, 'Marina', 'Delorenzo', 'marinadelorenzo@docente.unimarina.it', '1975-05-13', 7),
(3, 'Marina', 'Delorenzo', 'marinadelorenzo@docente.unimarina.it', '1975-05-13', 8),
(3, 'Marina', 'Delorenzo', 'marinadelorenzo@docente.unimarina.it', '1975-05-13', 9),
(4, 'Marco', 'Molfetta', 'marcomolfetta@docente.unimarina.it', '1980-01-30', 10),
(4, 'Marco', 'Molfetta', 'marcomolfetta@docente.unimarina.it', '1980-01-30', 11),
(4, 'Marco', 'Molfetta', 'marcomolfetta@docente.unimarina.it', '1980-01-30', 12),
(5, 'Fabio', 'Russo', 'fabiorusso@docente.unimarina.it', '1945-02-14', 13),
(5, 'Fabio', 'Russo', 'fabiorusso@docente.unimarina.it', '1945-02-14', 14),
(5, 'Fabio', 'Russo', 'fabiorusso@docente.unimarina.it', '1945-02-14', 15),
(6, 'Benedetta', 'Parodi', 'benedettaparodi@docente.unimarina.it', '1985-07-12', 16),
(6, 'Benedetta', 'Parodi', 'benedettaparodi@docente.unimarina.it', '1985-07-12', 17),
(6, 'Benedetta', 'Parodi', 'benedettaparodi@docente.unimarina.it', '1985-07-12', 18),
(7, 'Chiara', 'Izzo', 'chiaraizzo@docente.unimarina.it', '1956-08-27', 19),
(7, 'Chiara', 'Izzo', 'chiaraizzo@docente.unimarina.it', '1956-08-27', 20),
(7, 'Chiara', 'Izzo', 'chiaraizzo@docente.unimarina.it', '1956-08-27', 21),
(8, 'Francesco', 'Caio', 'francescocaio@docente.unimarina.it', '1940-10-05', 22),
(8, 'Francesco', 'Caio', 'francescocaio@docente.unimarina.it', '1940-10-05', 23),
(8, 'Francesco', 'Caio', 'francescocaio@docente.unimarina.it', '1940-10-05', 24),
(9, 'Giovanni', 'Izzo', 'giovanniizzo@docente.unimarina.it', '1985-03-15', 25),
(9, 'Giovanni', 'Izzo', 'giovanniizzo@docente.unimarina.it', '1985-03-15', 26),
(9, 'Giovanni', 'Izzo', 'giovanniizzo@docente.unimarina.it', '1985-03-15', 27),
(10, 'Giuseppe', 'Bianchi', 'giuseppebianchi@docente.unimarina.it', '1940-08-10', 28),
(10, 'Giuseppe', 'Bianchi', 'giuseppebianchi@docente.unimarina.it', '1940-08-10', 29),
(10, 'Giuseppe', 'Bianchi', 'giuseppebianchi@docente.unimarina.it', '1940-08-10', 30);

-- --------------------------------------------------------

--
-- Struttura della tabella `student`
--

CREATE TABLE `student` (
  `badgeNumber` bigint(32) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `personalEmail` varchar(45) NOT NULL,
  `istitutionalEmail` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `idPlainOfStudy` bigint(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `student`
--

INSERT INTO `student` (`badgeNumber`, `name`, `surname`, `personalEmail`, `istitutionalEmail`, `dateOfBirth`, `idPlainOfStudy`) VALUES
(10000, 'asaa', 'asdad', 'aaaaa@gmail.com', 'as.asdad@studenti.unimarina.it', '0017-02-13', 0),
(10002, 'mic', 'dan', 'mic@gmail.com', 'mi.dan@studenti.unimarina.it', '2018-04-28', 0),
(10003, 'asd', 'asd', 'asd@asd.it', 'as.asd@studenti.unimarina.it', '2018-04-28', 0),
(10004, 'asdf', 'asdf', 'asdf@gmail.com', 'as.asdf@studenti.unimarina.it', '2018-04-28', 0),
(10006, 'qweqr', 'eqwrqwrw', 'wqereqw@ewrqw.it', 'qw.eqwrqwrw@studenti.unimarina.it', '2018-04-28', 0),
(12345, 'Friz', 'Fritz', 'f.friz@gmail.it', 'f.friz@studenti.unimarina.it', '1990-01-01', 1),
(12346, 'Stefano', 'Ceccotti', 'stefanoceccotti89@gmail.com', 'St.Ceccotti@studenti.unimarina.it', '2018-04-05', 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`idExam`);

--
-- Indici per le tabelle `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`badgeNumber`,`istitutionalEmail`);

--
-- Indici per le tabelle `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`badgeNumber`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `login`
--
ALTER TABLE `login`
  MODIFY `badgeNumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12347;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
