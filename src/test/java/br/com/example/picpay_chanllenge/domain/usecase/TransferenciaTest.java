//package br.com.example.picpay_chanllenge.domain.usecase;
//
//import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyAuthorizer;
//import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyNotify;
//import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
//import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
//import br.com.example.picpay_chanllenge.domain.dto.out.AuthorizerOutDTO;
//import br.com.example.picpay_chanllenge.domain.entity.Transfer;
//import br.com.example.picpay_chanllenge.domain.entity.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class TransferenciaTest {
//
//    @Mock
//    private ThirdPartyAuthorizer transactionAuthorizer;
//    private TransferenciaRepository transferenciaRepository;
//    private ThirdPartyNotify thirdPartyNotify;
//    private UserRepository userRepository;
//
//    private User user1;
//    private User user2;
//    private Transfer transfer;
//
//    @BeforeEach
//    void setUp() {
//        transactionAuthorizer = mock(ThirdPartyAuthorizer.class);
//        transferenciaRepository = mock(TransferenciaRepository.class);
//        thirdPartyNotify = mock(ThirdPartyNotify.class);
//        userRepository = mock(UserRepository.class);
//        this.user1 = new User(0L,
//                "Jonas Silveira",
//                14135225721L,
//                "jonasdasilvasilveira@gmail.com",
//                "1234",
//                false,
//                100L);
//        this.user2 = new User(1L,
//                "Daniel Silveira",
//                14135225721L,
//                "jonasdasilvasilveira@gmail.com",
//                "1234",
//                false,
//                100L);
//        this.transfer = new Transfer(
//                0L,
//                100L,
//                user1,
//                user2);
//    }
//
//    @Test
//    void transfereSuccessfull() {
//        Transferencia transferencia = new Transferencia(transactionAuthorizer,
//                transferenciaRepository,
//                thirdPartyNotify,
//                userRepository);
//        when(transactionAuthorizer.authorize()).thenReturn(new AuthorizerOutDTO("success", Map.of("authorization", true)));
//
//        Boolean transfere = transferencia.transfere();
//        verify(transferenciaRepository, times(1)).merge(transfer);
//        verify(thirdPartyNotify, times(1)).pushNotify();
//        verify(userRepository, times(1)).withdraw(user1.getId(), 100L);
//        verify(userRepository, times(1)).deposit(user2.getId(), 100L);
//        assertTrue(transfere);
//
//    }
//
//    @Test
//    void transfereFailWhenAuthorizationFails() {
//        Transferencia transferencia = new Transferencia(transactionAuthorizer,
//                transferenciaRepository,
//                thirdPartyNotify,
//                userRepository);
//        when(transactionAuthorizer.authorize()).thenReturn(new AuthorizerOutDTO("fail", Map.of("authorization", false)));
//
//        Boolean transfere = transferencia.transfere();
//        verify(transferenciaRepository, never()).merge(transfer);
//        verify(thirdPartyNotify, never()).pushNotify();
//        verify(userRepository, never()).withdraw(user1.getId(), 100L);
//        verify(userRepository, never()).deposit(user2.getId(), 100L);
//        assertFalse(transfere);
//
//    }
//
//    @Test
//    void transfereFailWhenValueItIsHigherThanSaldo() {
//        this.transfer = new Transfer(
//                0L,
//                200L,
//                user1,
//                user2);
//        Transferencia transferencia = new Transferencia(transactionAuthorizer,
//                transferenciaRepository,
//                thirdPartyNotify,
//                userRepository);
//        when(transactionAuthorizer.authorize()).thenReturn(new AuthorizerOutDTO("fail", Map.of("authorization", true)));
//
//        Boolean transfere = transferencia.transfere();
//        verify(transferenciaRepository, never()).merge(transfer);
//        verify(thirdPartyNotify, never()).pushNotify();
//        verify(userRepository, never()).withdraw(user1.getId(), 100L);
//        verify(userRepository, never()).deposit(user2.getId(), 100L);
//        assertFalse(transfere);
//
//    }
//
//    @Test
//    void transfereFailWhenPayerIsAShopKeeper() {
//        this.user1 = new User(0L,
//                "Jonas Silveira",
//                14135225721L,
//                "jonasdasilvasilveira@gmail.com",
//                "1234",
//                true,
//                100L);
//        this.transfer = new Transfer(
//                0L,
//                100L,
//                user1,
//                user2);
//        Transferencia transferencia = new Transferencia(transactionAuthorizer,
//                transferenciaRepository,
//                thirdPartyNotify,
//                userRepository);
//        when(transactionAuthorizer.authorize()).thenReturn(new AuthorizerOutDTO("success", Map.of("authorization", true)));
//
//        Boolean transfere = transferencia.transfere();
//        verify(transferenciaRepository, never()).merge(transfer);
//        verify(thirdPartyNotify, never()).pushNotify();
//        verify(userRepository, never()).withdraw(user1.getId(), 100L);
//        verify(userRepository, never()).deposit(user2.getId(), 100L);
//        assertFalse(transfere);
//
//    }
//
//    @Test
//    void transfereFailWhenValueIsZero() {
//        this.transfer = new Transfer(
//                0L,
//                0L,
//                user1,
//                user2);
//        Transferencia transferencia = new Transferencia(transactionAuthorizer,
//                transferenciaRepository,
//                thirdPartyNotify,
//                userRepository);
//        when(transactionAuthorizer.authorize()).thenReturn(new AuthorizerOutDTO("success", Map.of("authorization", true)));
//
//        Boolean transfere = transferencia.transfere();
//        verify(transferenciaRepository, never()).merge(transfer);
//        verify(thirdPartyNotify, never()).pushNotify();
//        verify(userRepository, never()).withdraw(user1.getId(), 100L);
//        verify(userRepository, never()).deposit(user2.getId(), 100L);
//        assertFalse(transfere);
//
//    }
//}